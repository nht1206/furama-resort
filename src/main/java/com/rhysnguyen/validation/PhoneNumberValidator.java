package com.rhysnguyen.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.matches("(09|05|03|06)+[0-9]{8}") || value.matches("([(]84[)][+])+(9|5|3|7|8)+[0-9]{8}");
    }
    
}