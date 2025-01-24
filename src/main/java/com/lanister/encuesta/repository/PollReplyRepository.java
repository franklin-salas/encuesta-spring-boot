package com.lanister.encuesta.repository;


import com.lanister.encuesta.entity.PollReply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollReplyRepository extends CrudRepository<PollReply,Long> {
}
