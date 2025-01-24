package com.lanister.encuesta.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private Date timestamp;
    private String message;
    private  int status;

}
