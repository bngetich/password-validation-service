package com.example.password.validator.components;

import java.util.List;

public abstract class PasswordRuleComponentDecorator implements PasswordRuleComponent {

    protected final PasswordRuleComponent passwordRuleComponent;

    public PasswordRuleComponentDecorator(PasswordRuleComponent passwordRuleComponent) {
        this.passwordRuleComponent = passwordRuleComponent;
    }

    @Override
    public String isPasswordValid(String password) {
        return this.passwordRuleComponent.isPasswordValid(password);
    }
}
