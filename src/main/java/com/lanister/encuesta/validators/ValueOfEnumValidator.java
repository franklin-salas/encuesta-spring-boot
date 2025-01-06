package com.lanister.encuesta.validators;

import com.lanister.encuesta.annotations.ValueOfEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValueOfEnumValidator  implements ConstraintValidator<ValueOfEnum, String> {
    private List<String> acceptedValues;


    @Override
    public void initialize(ValueOfEnum annotation) {
//        ConstraintValidator.super.initialize(annotation);
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return  false;

        return acceptedValues.contains(value);
    }
}
