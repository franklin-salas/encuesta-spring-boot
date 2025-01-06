/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.encuesta.exception;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author frank
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrors {
    
    private Map<String,String> errors;
    private Date timestamp;
    
}
