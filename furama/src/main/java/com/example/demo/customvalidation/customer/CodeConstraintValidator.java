package com.example.demo.customvalidation.customer;

import com.example.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CodeConstraintValidator implements ConstraintValidator<SameCodeCustomer, String> {
    @Autowired
    CustomerService customerService;
    public void initialize(SameCodeCustomer constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        Boolean value=customerService.checkCode(obj);
        return value;
    }
}
