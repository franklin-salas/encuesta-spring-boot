package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.PollReplyRequest;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.entity.PollReply;
import com.lanister.encuesta.entity.PollReplyDetail;
import com.lanister.encuesta.repository.PollReplyRepository;
import com.lanister.encuesta.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class PollReplyServiceImpl implements PollReplyService{
    private PollReplyRepository pollReplyRepository;
    private PollRepository pollRepository;
    @Override
    public void createPollReply(PollReplyRequest pollReplyRequest) {
        ModelMapper mapper  = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        PollReply pollReply = mapper.map(pollReplyRequest,PollReply.class);

        Poll poll= pollRepository.findById(pollReplyRequest.getPoll());
        if(poll == null){
            throw new RuntimeException("Poll not found");
        }

        //Map<Long,Long> uniqueReplies = new HashMap<>();
        Set<Long> uniqueReplies = new HashSet<>();
        pollReply.setPoll(poll);
        for (PollReplyDetail pollReplyDetail: pollReply.getPollReplies()){
            pollReplyDetail.setPollReply(pollReply);
            //uniqueReplies.put(pollReplyDetail.getQuestionId(),pollReplyDetail.getQuestionId());
            uniqueReplies.add(pollReplyDetail.getQuestionId());
        }

        if (uniqueReplies.size() != poll.getQuestions().size()){
            throw new RuntimeException("You must answer all the questions");
        }
        pollReplyRepository.save(pollReply);


    }
}
