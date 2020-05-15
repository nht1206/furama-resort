package com.rhysnguyen.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentityCardValidator implements ConstraintValidator<IdentityCard, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return value.matches("^[0-9]{9}$");
    }
    
}