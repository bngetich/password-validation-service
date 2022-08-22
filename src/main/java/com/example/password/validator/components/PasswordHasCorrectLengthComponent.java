package com.example.password.validator.components;

import com.example.password.validator.service.PasswordValidatorService;

/**
 * PasswordValidatorComponentDecorator that adds validation check for min/max password length
 */
public class PasswordHasCorrectLengthComponent extends PasswordValidatorComponentDecorator {
    public static final String ERROR_STRING = "Password must be between 5 and 12 characters in length";

    public PasswordHasCorrectLengthComponent(PasswordValidatorComponent passwordValidatorComponent) {
        super(passwordValidatorComponent);
    }

    @Override
    public void isPasswordValid(String password) {
        super.isPasswordValid(password);
        boolean isValid = (password.length() >= 5) & (password.length() <= 12);

        if(!isValid){
            PasswordValidatorService.validationResults.add(ERROR_STRING);
        }

    }
}
