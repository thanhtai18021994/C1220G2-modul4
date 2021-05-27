package com.example.demo.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GeneralPhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    public void initialize(Phone constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return obj.matches("^(((090|091)\\d{7}))|(\\(84\\)(90|91)\\d{7})$");
    }
}
