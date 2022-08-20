package com.example.password.validator.components;

import com.example.password.validator.PasswordValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PasswordValidatorComponentDecorator that adds validation checks for subsequent repetition of sub-sequences
 */
public class PasswordHasNoRepeatSequenceComponent extends PasswordValidatorComponentDecorator {

    public static final String ERROR_STRING = "Password must not contain any sequence of characters immediately followed by the same sequence";

    public static final String REGEX = "(.+?)(\\1+?)";

    public PasswordHasNoRepeatSequenceComponent(PasswordValidatorComponent passwordValidatorComponent) {
        super(passwordValidatorComponent);
    }

    @Override
    public void isPasswordValid(String password) {
        super.isPasswordValid(password);
        System.out.println(PasswordHasNoRepeatSequenceComponent.class.toString());

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(password);

        boolean isValid = !matcher.find();

        if(!isValid){
            PasswordValidator.validationResults.add(ERROR_STRING);
        }
    }
}
