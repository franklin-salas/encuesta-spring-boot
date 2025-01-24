package com.lanister.encuesta.repository;


import com.lanister.encuesta.dto.response.PollResultResponse;
import com.lanister.encuesta.entity.Poll;
import com.lanister.encuesta.interfaces.PollResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends CrudRepository<Poll,Long> {
     Poll findByPollId(String pollId);
     Poll findById(long id);
     Page<Poll> findAllByUserId(long userId, Pageable pageable);
     Poll findByPollIdAndUserId(String pollId, long userId);
     @Query(value = "SELECT q.question_order questionOrder, prd.question_id questionId, q.content question, prd.answer_id answerId, a.content answer, count(prd.answer_id) result " +
             "FROM poll_replies pr " +
             "LEFT JOIN poll_reply_details prd ON prd.poll_reply_id = pr.id "+
             "LEFT JOIN answers a ON a.id = prd.answer_id " +
             "LEFT JOIN questions q ON q.id = prd.question_id " +
             "WHERE pr.poll_id = :pollId " +
             "GROUP BY prd.question_id, prd.answer_id " +
             "ORDER BY q.question_order ASC"
      ,nativeQuery = true)
     List<PollResult> getPollResults(@Param("pollId") long id);
}
