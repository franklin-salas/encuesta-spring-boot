package com.lanister.encuesta.service;

import com.lanister.encuesta.dto.request.UserRegisterRequest;
import com.lanister.encuesta.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public User crearUser(UserRegisterRequest userRegisterRequest);
    public User getUser(String email);
}
