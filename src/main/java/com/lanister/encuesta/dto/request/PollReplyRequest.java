package com.lanister.encuesta.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollReplyRequest {
    @NotEmpty
    private String user;
    @NotNull
    @Positive
    private long poll;
    @Valid
    @NotEmpty
    @Size(min = 1)
    private List<PollReplyDetailRequest> pollReplies;
}
