package com.lanister.encuesta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PollResultWrapperResponse {

    private List<PollResultResponse> results;
    private String content;
    private long id;
}
