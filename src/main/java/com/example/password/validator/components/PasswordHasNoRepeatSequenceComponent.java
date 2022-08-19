package com.example.password.validator.components;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordHasNoRepeatSequenceComponent extends PasswordRuleComponentDecorator {

    public static final String ERROR_STRING = "Password must not contain any sequence of characters immediately followed by the same sequence.";

    public static final String REGEX = "(.+?)(\\1+?)";

    public PasswordHasNoRepeatSequenceComponent(PasswordRuleComponent passwordRuleComponent) {
        super(passwordRuleComponent);
    }

    @Override
    public String isPasswordValid(String password) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(password);

        boolean isValid = !matcher.find();

        return isValid ? new String("") : ERROR_STRING;
    }
}
