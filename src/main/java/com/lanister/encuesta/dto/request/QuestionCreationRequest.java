package com.lanister.encuesta.dto.request;

import com.lanister.encuesta.annotations.ValueOfEnum;
import com.lanister.encuesta.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreationRequest {
    @NotEmpty
    private String content;
    @NotNull
    @Range(min = 1, max = 30)
    private int questionOrder;
    @NotEmpty
    @ValueOfEnum(enumClass = QuestionType.class)
    private String type;
    @Valid
    @NotEmpty
    @Size(min = 1, max = 10)
    private List<AnswerCreationRequest> answers;

}
