package com.example.password.validator.components;

/**
 * base for all PasswordValidatorDecorators
 */
public abstract class PasswordValidatorComponentDecorator implements PasswordValidatorComponent {

    private final PasswordValidatorComponent passwordValidatorComponent;

    public PasswordValidatorComponentDecorator(PasswordValidatorComponent passwordValidatorComponent) {
        this.passwordValidatorComponent = passwordValidatorComponent;
    }

    @Override
    public void isPasswordValid(String password) {
        passwordValidatorComponent.isPasswordValid(password);
    }
}
