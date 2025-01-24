package com.lanister.encuesta.controller;

import com.lanister.encuesta.dto.request.PollReplyRequest;
import com.lanister.encuesta.service.PollReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/polls/reply")
public class PollReplyController {

    @Autowired
    private PollReplyService pollReplyService;
    @PostMapping
    public void replyPoll(@RequestBody @Valid PollReplyRequest pollReplyRequest){
        pollReplyService.createPollReply(pollReplyRequest);
    }
}
