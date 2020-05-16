package com.rhysnguyen.casestudyjavaweb.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.jvnet.staxex.StAxSOAPBody.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ResortCodeValidator.class)
public @interface ResortCode {
    public String message() default "The code is not valid.";
    public String regex();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}