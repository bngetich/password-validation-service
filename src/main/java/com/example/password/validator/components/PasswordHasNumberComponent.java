package com.example.password.validator.components;

import com.example.password.validator.service.PasswordValidatorService;

/**
 * PasswordValidatorDecorator that adds checking for at least one numeric character.
 */
public class PasswordHasNumberComponent extends PasswordValidatorComponentDecorator {

    public static final String ERROR_STRING = "Password must contain at least one numeric character";

    public static final String REGEX = "(.*[0-9].*)";

    public PasswordHasNumberComponent(PasswordValidatorComponent passwordValidatorComponent) {
        super(passwordValidatorComponent);
    }

    @Override
    public void isPasswordValid(String password) {
        super.isPasswordValid(password);
        boolean isValid = password.matches(REGEX);

        if(!isValid){
            PasswordValidatorService.validationResults.add(ERROR_STRING);
        }
    }
}
