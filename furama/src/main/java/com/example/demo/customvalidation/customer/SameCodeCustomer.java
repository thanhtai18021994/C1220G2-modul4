package com.example.demo.customvalidation.customer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface SameCodeCustomer {
    public String message() default "Ma khach hang trung lap";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
