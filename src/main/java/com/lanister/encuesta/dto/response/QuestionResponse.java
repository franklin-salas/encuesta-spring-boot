package com.lanister.encuesta.dto.response;



import com.lanister.encuesta.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

    private long id;
    private String content;
    private  int questionOrder;
    private QuestionType type;
    private List<AnswerResponse> answers;
}
