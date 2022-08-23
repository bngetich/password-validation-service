package com.example.password.validator.service;

import com.example.password.validator.bundles.PasswordValidatorBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that performs password validation. Injected to the controller to call its validate method.
 * Prototype scoped, so we get a new instance everytime with new validation results array. (don't know if this is the right design)
 */
@Service
@Scope("prototype")
public class PasswordValidatorService {


    private PasswordValidatorBundle passwordValidatorBundle;

    public static List<String> validationResults = new ArrayList<>();

    @Autowired
    public PasswordValidatorService(@Qualifier("passwordValidatorBundle_Full") PasswordValidatorBundle passwordValidatorBundle) {
        this.passwordValidatorBundle = passwordValidatorBundle;
        validationResults = new ArrayList<>();
    }


    public List<String> validate(String password)  {
        passwordValidatorBundle.isPasswordValid(password);

        return validationResults;
    }
}
