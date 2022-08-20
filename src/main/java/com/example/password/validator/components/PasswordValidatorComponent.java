package com.example.password.validator.components;

/**
 * interface establishing a contract for all PasswordValidatorComponents(Wrappers and Wrapped objects)
 */
public interface PasswordValidatorComponent {
    public void isPasswordValid(String password);
}
