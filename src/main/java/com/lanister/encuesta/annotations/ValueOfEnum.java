package com.lanister.encuesta.annotations;


import com.lanister.encuesta.validators.ValueOfEnumValidator;

import javax.validation.Payload;
import javax.validation.Constraint;

import java.lang.annotation.*;

@Constraint(validatedBy = ValueOfEnumValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValueOfEnum {
    Class<? extends  Enum<?> > enumClass();
    String message() default  "{encuesta.constraints.enum.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
