package com.example.demo.customvalidation.customer;

import com.example.demo.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneConstraintValidator implements ConstraintValidator<SamePhone, String> {
    @Autowired
    CustomerService customerService;
    public void initialize(SamePhone constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        Boolean value=customerService.checkPhone(obj);
        return value;
    }
}
