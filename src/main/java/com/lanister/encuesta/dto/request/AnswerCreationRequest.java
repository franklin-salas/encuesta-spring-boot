package com.lanister.encuesta.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreationRequest {
    @NotEmpty
    private String content;
}
