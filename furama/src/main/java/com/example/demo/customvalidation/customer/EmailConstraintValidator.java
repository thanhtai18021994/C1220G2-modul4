package com.example.demo.customvalidation.customer;

import com.example.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailConstraintValidator implements ConstraintValidator<SameEmail, String> {
    @Autowired
    CustomerService customerService;
    public void initialize(SameEmail constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return obj!=null&&!customerService.checkEmail(obj);
    }
}
