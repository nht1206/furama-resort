package com.rhysnguyen.casestudyjavaweb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ResortCodeValidator implements ConstraintValidator<ResortCode, String> {

    private ResortCode constraintAnnotation;

    @Override
    public void initialize(final ResortCode constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(final String code, final ConstraintValidatorContext context) {
        if (code == null) {
            return true;
        }        
        return code.matches(constraintAnnotation.regex());
    }
    
}