package com.lanister.encuesta.repository;


import com.lanister.encuesta.entity.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll,Long> {
}
