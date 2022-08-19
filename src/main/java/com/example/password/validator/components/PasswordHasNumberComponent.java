package com.example.password.validator.components;

import java.util.List;

public class PasswordHasNumberComponent extends PasswordRuleComponentDecorator {

    public static final String ERROR_STRING = "Password must contain at least one numeric character";

    public static final String REGEX = "(?=.*[0-9])";

    public PasswordHasNumberComponent(PasswordRuleComponent passwordRuleComponent) {
        super(passwordRuleComponent);
    }

    @Override
    public String isPasswordValid(String password) {
        boolean isValid = password.matches(REGEX);

        return isValid ? new String("") : ERROR_STRING;
    }
}
