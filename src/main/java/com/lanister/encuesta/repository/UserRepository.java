/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lanister.encuesta.repository;

import com.lanister.encuesta.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author frank
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
    public User findByEmail(String email);
}
