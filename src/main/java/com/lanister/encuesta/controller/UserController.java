/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.encuesta.controller;

import com.lanister.encuesta.dto.request.UserRegisterRequest;
import com.lanister.encuesta.dto.response.UserResponse;
import com.lanister.encuesta.entity.User;
import com.lanister.encuesta.service.UserServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author frank
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping
    public UserResponse createUsers(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
        User user = userService.crearUser(userRegisterRequest);
        UserResponse response =  new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }
    @GetMapping
    public  UserResponse getUser(Authentication authentication){

        User user = userService.getUser(authentication.getPrincipal().toString());
        UserResponse response =  new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }

    
}
