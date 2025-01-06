package com.lanister.encuesta.dto.request;

import com.lanister.encuesta.annotations.ValueOfEnum;
import com.lanister.encuesta.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollCreationRequest {
    @NotEmpty
    private String content;
    @NotNull

    private boolean opened;
    @Valid
    @NotEmpty
    @Size(min = 1, max = 30)
    private List<QuestionCreationRequest> questions;


}