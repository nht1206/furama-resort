package com.rhysnguyen.casestudyjavaweb.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  PhoneNumberValidator.class)
public @interface PhoneNumber {
    public String message() default "Phone number is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}