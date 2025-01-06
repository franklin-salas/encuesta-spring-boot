package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.PollCreationRequest;

public interface IPollService {
    public String creatrePoll(PollCreationRequest pollCreationRequest, String email);
}
