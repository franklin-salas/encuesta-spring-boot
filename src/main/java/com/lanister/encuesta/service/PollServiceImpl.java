package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.PollCreationRequest;
import com.lanister.encuesta.entity.Answer;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.entity.Question;
import com.lanister.encuesta.entity.User;
import com.lanister.encuesta.repository.IUserRepository;
import com.lanister.encuesta.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class PollServiceImpl implements IPollService{

    PollRepository pollRepository;
    IUserRepository userRepository;
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
}
