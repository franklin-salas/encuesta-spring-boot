package com.lanister.encuesta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDetailResponse {
    private  String answer;
    private long result;
}
