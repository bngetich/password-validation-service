package com.example.password.validator.components;

import java.util.List;

public class PasswordHasCorrectLengthComponent extends PasswordRuleComponentDecorator {
    public static final String ERROR_STRING = "Password must be between 5 and 12 characters in length";

    public PasswordHasCorrectLengthComponent(PasswordRuleComponent passwordRuleComponent) {
        super(passwordRuleComponent);
    }

    @Override
    public String isPasswordValid(String password) {
        boolean isValid = (password.length() >= 5) & (password.length() <= 12);

        return isValid ? new String("") : ERROR_STRING;

    }
}
