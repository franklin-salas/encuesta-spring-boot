package com.lanister.encuesta.dto.response;

import com.lanister.encuesta.entity.Question;
import com.lanister.encuesta.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PollResponse {

    private Long id;
    private String pollId;
    private String content;
    private  boolean opened;
    private List<QuestionResponse> questions;
}
