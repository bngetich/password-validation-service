package com.example.password.validator;

import com.example.password.validator.bundles.PasswordValidatorBundle;
import com.example.password.validator.components.PasswordRuleComponent;

import java.util.ArrayList;
import java.util.List;


public class PasswordValidator {
    private final PasswordValidatorBundle passwordValidatorBundle;

    public PasswordValidator(PasswordValidatorBundle passwordValidatorBundle) {
        this.passwordValidatorBundle = passwordValidatorBundle;
    }

    //Function to check whether
    // the password is valid or not
    public String validate(String password)  {
        String validationResults = passwordValidatorBundle.isPasswordValid(password);

        return validationResults;
    }
}
