package com.example.password.validator.components;

import com.example.password.validator.service.PasswordValidatorService;

/**
 * PasswordValidatorDecorator that adds checking for at least one lowercase character.
 */
public class PasswordHasLowerCaseComponent extends PasswordValidatorComponentDecorator {

    public static final String ERROR_STRING = "Password must contain at least one lowercase character";

    public static final String REGEX = "(.*[a-z].*)";

    public PasswordHasLowerCaseComponent(PasswordValidatorComponent passwordValidatorComponent) {
        super(passwordValidatorComponent);
    }


    @Override
    public void isPasswordValid(String password) {
        super.isPasswordValid(password);
        boolean isValid = password.matches(REGEX);

        if (!isValid) {
            PasswordValidatorService.validationResults.add(ERROR_STRING);
        }
    }
}
