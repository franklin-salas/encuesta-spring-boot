package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import com.lanister.encuesta.dto.response.PollResultResponse;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.interfaces.PollResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PollService {
     String creatrePoll(PollCreationRequest pollCreationRequest, String email);
     Poll getPoll(String pollId);
     Page<Poll> getPolls(int page ,int limit, String email);
     void togglePollOpened(String pollId, String email);
     void deletePoll(String pollId, String email);
     List<PollResult> getResults(String pollId, String email);
}
