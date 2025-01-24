package com.lanister.encuesta.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollReplyDetailRequest {
    @NotNull
    @Positive
    private  long questionId;
    @NotNull
    @Positive
    private  long answerId;

}
