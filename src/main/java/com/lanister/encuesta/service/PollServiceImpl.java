package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import com.lanister.encuesta.dto.response.PollResultResponse;
import com.lanister.encuesta.entity.Answer;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.entity.Question;
import com.lanister.encuesta.entity.User;
import com.lanister.encuesta.interfaces.PollResult;
import com.lanister.encuesta.repository.UserRepository;
import com.lanister.encuesta.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PollServiceImpl implements PollService {

    PollRepository pollRepository;
    UserRepository userRepository;
    @Override
    public String creatrePoll(PollCreationRequest pollCreationRequest, String email) {
        User user = userRepository.findByEmail(email);
        ModelMapper mapper = new ModelMapper();
        Poll poll = mapper.map(pollCreationRequest,Poll.class);
        poll.setUser(user);
        poll.setPollId(UUID.randomUUID().toString());
        for (Question question: poll.getQuestions()){
            question.setPoll(poll);
            for(Answer answer: question.getAnswers()){
                answer.setQuestion(question);
            }
        }
        pollRepository.save(poll);

        return poll.getPollId();
    }

    @Override
    public Poll getPoll(String pollId) {
        Poll poll = pollRepository.findByPollId(pollId);
        if (poll == null ){
            throw new RuntimeException("Poll not found");
        }
        if (!poll.isOpened()){
            throw new RuntimeException("Poll does not accept more replies");
        }

        return poll;
    }

    @Override
    public Page<Poll> getPolls(int page, int limit, String email) {

        User user = userRepository.findByEmail(email);
        Pageable pageable = PageRequest.of(page,limit);
        Page<Poll> paginatedPoll = this.pollRepository.findAllByUserId(user.getId(), pageable);
        return paginatedPoll;
    }

    @Override
    public void togglePollOpened(String pollId, String email) {
        User user = userRepository.findByEmail(email);
        Poll poll = pollRepository.findByPollIdAndUserId(pollId,user.getId());
        if (poll == null){
            throw new RuntimeException("Poll not found");
        }

        poll.setOpened(!poll.isOpened());
        pollRepository.save(poll);

    }

    @Override
    public void deletePoll(String pollId, String email) {
        User user = userRepository.findByEmail(email);
        Poll poll = pollRepository.findByPollIdAndUserId(pollId,user.getId());
        if (poll == null){
            throw new RuntimeException("Poll not found");
        }
        pollRepository.delete(poll);
    }

    @Override
    public List<PollResult> getResults(String pollId, String email) {

        User user = userRepository.findByEmail(email);
        Poll poll = pollRepository.findByPollIdAndUserId(pollId,user.getId());
        if (poll == null){
            throw new RuntimeException("Poll not found");
        }

        return pollRepository.getPollResults(poll.getId());
    }
}
