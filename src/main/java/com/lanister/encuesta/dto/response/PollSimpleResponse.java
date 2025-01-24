package com.lanister.encuesta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PollSimpleResponse {

    private Long id;
    private String pollId;
    private String content;
    private  boolean opened;

}
