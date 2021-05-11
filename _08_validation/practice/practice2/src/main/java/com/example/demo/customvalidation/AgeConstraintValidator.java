package com.example.demo.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<Age, Integer> {
    public void initialize(Age constraint) {
    }

    @Override
    public boolean isValid(Integer obj, ConstraintValidatorContext context) {
        boolean value= (obj+"").matches("^[0-9]{1,3}$")&&obj>=18&&obj<100;
        return value;
    }

}
