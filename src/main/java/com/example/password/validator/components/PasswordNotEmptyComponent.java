package com.example.password.validator.components;

import com.example.password.validator.service.PasswordValidatorService;

/**
 * Component that adds validation check for empty password. Is also the base/concrete component class(Decorator Pattern)
 */
public class PasswordNotEmptyComponent implements PasswordValidatorComponent {

    public static final String ERROR_STRING = "Password must not be empty";

    @Override
    public void isPasswordValid(String password) {
        boolean isValid = !password.isEmpty();

        if(!isValid){
            PasswordValidatorService.validationResults.add(ERROR_STRING);
        }
    }


}
