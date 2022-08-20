package com.example.password.validator;

import com.example.password.validator.bundles.PasswordValidatorBundle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * wrapper for a given password validator bundle. think of the bundle like an engine and this as the rest of the car
 */
@Service
public class PasswordValidator {

    private final PasswordValidatorBundle passwordValidatorBundle;

    public static List<String> validationResults = new ArrayList<>();

    public PasswordValidator(PasswordValidatorBundle passwordValidatorBundle) {
        validationResults = new ArrayList<>();
        this.passwordValidatorBundle = passwordValidatorBundle;
    }

    //Function to check whether
    // the password is valid or not
    public List<String> validate(String password)  {
        passwordValidatorBundle.isPasswordValid(password);

        return validationResults;
    }
}
