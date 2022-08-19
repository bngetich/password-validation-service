package com.example.password.validator.components;

import org.springframework.util.StringUtils;

import java.util.List;

public class PasswordNotEmptyComponent implements PasswordRuleComponent {

    public static final String ERROR_STRING = "Password must not be empty";

    @Override
    public String isPasswordValid(String password) {
        boolean isValid = !password.isEmpty();

        return isValid ? new String("") : ERROR_STRING;
    }


}
