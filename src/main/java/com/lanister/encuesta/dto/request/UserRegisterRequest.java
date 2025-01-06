/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.encuesta.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lanister.encuesta.annotations.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author frank
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    
@NotEmpty
private String name;
@NotEmpty
@Email
@UniqueEmail
private String email;
@NotEmpty
@Size(min = 8 , max = 20)
private String password;
}
