package com.lanister.encuesta.validators;

import com.lanister.encuesta.annotations.UniqueEmail;
import com.lanister.encuesta.entity.User;
import com.lanister.encuesta.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    IUserRepository iUserRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        User user = iUserRepository.findByEmail(value);
        if(user == null){
            return true;
        }
        return false;
    }
}
