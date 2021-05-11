package com.example.demo.customvalidation;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameConstraintValidator implements ConstraintValidator<Name, String> {
    @Autowired
    UserService userService;

    public void initialize(Name constraint) {
    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        boolean value=!userService.checkName(obj);
        return value;
    }
}
