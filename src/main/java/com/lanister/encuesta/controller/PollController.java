package com.lanister.encuesta.controller;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import com.lanister.encuesta.dto.response.*;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.interfaces.PollResult;
import com.lanister.encuesta.service.PollService;
import com.lanister.encuesta.utils.transformer.PollResultTransformer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    PollService pollService;

    @PostMapping
    public PollCreatedResponse createPoll(@RequestBody @Valid PollCreationRequest  pollCreationRequest, Authentication authentication){

        String pollId = pollService.creatrePoll(pollCreationRequest,authentication.getPrincipal().toString() );
        return  new PollCreatedResponse(pollId);
    }

    @GetMapping(path = "{id}/questions")
    public PollResponse getPollWithQuestions(@PathVariable String id){

        Poll poll = pollService.getPoll(id);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(poll, PollResponse.class);
    }
    @GetMapping
    public PaginatedPollResponse getPolls(@RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "limit", defaultValue = "10") int limit,
                         Authentication authentication){
        Page<Poll> paginatedPolls = this.pollService.getPolls(page,limit,authentication.getPrincipal().toString());

        ModelMapper mapper = new ModelMapper();
       // mapper.typeMap(Poll.class, PollResponse.class).addMappings(m -> m.skip(PollResponse::setQuestions));
        PaginatedPollResponse paginatedPollResponse = new PaginatedPollResponse();
        paginatedPollResponse.setPolls(
                paginatedPolls.getContent().stream().map( p -> mapper.map(p, PollSimpleResponse.class)).collect(Collectors.toList())
        );
        paginatedPollResponse.setTotalPages(paginatedPolls.getTotalPages());
        paginatedPollResponse.setTotalRecords(paginatedPolls.getTotalElements());
        paginatedPollResponse.setCurrentPageRecords(paginatedPolls.getNumberOfElements());
        paginatedPollResponse.setCurrentPage(paginatedPolls.getPageable().getPageNumber() + 1);

        return paginatedPollResponse;
    }


    @PatchMapping(path = "/{id}")
    public void togglePollOpened(@PathVariable String id, Authentication authentication){
        pollService.togglePollOpened(id,authentication.getPrincipal().toString());
    }

    @DeleteMapping(path = "/{id}")
    public void deletePoll(@PathVariable String id, Authentication authentication){
        pollService.deletePoll(id,authentication.getPrincipal().toString());
    }

    @GetMapping(path = "/{id}/results")
    public PollResultWrapperResponse getResults(@PathVariable String id, Authentication authentication){
        List<PollResult> result = pollService.getResults(id,authentication.getPrincipal().toString());        PollResultTransformer pollResultTransformer = new PollResultTransformer();
        Poll poll = pollService.getPoll(id);

        return  new PollResultWrapperResponse(pollResultTransformer.transformData(result),poll.getContent(),poll.getId());
    }
}
