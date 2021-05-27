package com.example.demo.customvalidation;

import com.example.demo.customvalidation.customer.EmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GeneralPhoneConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    public String message() default "090|091|(84)90(xxxxxxx)";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
