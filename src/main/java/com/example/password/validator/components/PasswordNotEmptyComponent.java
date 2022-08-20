package com.example.password.validator.components;

import com.example.password.validator.PasswordValidator;

/**
 * Component that adds validation check for empty password. Is also the base/concrete component class(Decorator Pattern)
 */
public class PasswordNotEmptyComponent implements PasswordValidatorComponent {

    public static final String ERROR_STRING = "Password must not be empty";

    @Override
    public void isPasswordValid(String password) {
        System.out.println(PasswordNotEmptyComponent.class.toString());
        boolean isValid = !password.isEmpty();

        if(!isValid){
            PasswordValidator.validationResults.add(ERROR_STRING);
        }
    }


}
