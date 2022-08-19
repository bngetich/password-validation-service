package com.example.password.validator.components;

import java.util.List;

public class PasswordHasLowerCaseComponent extends PasswordRuleComponentDecorator {

    public static final String ERROR_STRING = "Password must contain at least one lowercase character";

    public static final String REGEX = "(.*[a-z].*)";

    public PasswordHasLowerCaseComponent(PasswordRuleComponent passwordRuleComponent) {
        super(passwordRuleComponent);
    }


    @Override
    public String isPasswordValid(String password) {
        boolean isValid = password.matches(REGEX);

        return isValid ? new String("") : ERROR_STRING;
    }
}
