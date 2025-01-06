package com.lanister.encuesta.controller;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import com.lanister.encuesta.dto.response.PollCreatedResponse;
import com.lanister.encuesta.service.IPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    IPollService pollService;

    @PostMapping
    public PollCreatedResponse createPoll(@RequestBody @Valid PollCreationRequest  pollCreationRequest, Authentication authentication){

        String pollUuid = pollService.creatrePoll(pollCreationRequest,authentication.getPrincipal().toString() );
        return  new PollCreatedResponse(pollUuid);
    }
}
