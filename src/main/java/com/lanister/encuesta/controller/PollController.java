package com.lanister.encuesta.controller;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/polls")
public class PollController {

    @PostMapping
    public String createPoll(@RequestBody @Valid PollCreationRequest  pollCreationRequest, Authentication authentication){

        System.out.println(pollCreationRequest);
        return authentication.getPrincipal().toString();
    }
}
