package com.example.password.validator.bundles;

import com.example.password.validator.components.PasswordNotEmptyComponent;
import com.example.password.validator.components.PasswordRuleComponent;
import com.example.password.validator.components.PasswordRuleComponentDecorator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class PasswordValidatorBundle {

    private final PasswordRuleComponent passwordRuleComponent;
    public final List<Class<? extends PasswordRuleComponentDecorator>> passwordRuleDecoratorList;

    protected PasswordValidatorBundle(List<Class<? extends PasswordRuleComponentDecorator>> passwordRuleDecoratorList) {
        PasswordRuleComponent passwordRuleComponent = new PasswordNotEmptyComponent(); //concrete component
        this.passwordRuleDecoratorList = passwordRuleDecoratorList;

        for (Class<? extends PasswordRuleComponentDecorator> passwordRuleDecoratorClazz : this.passwordRuleDecoratorList){

            try{
                passwordRuleComponent = passwordRuleDecoratorClazz.getConstructor(PasswordRuleComponent.class)
                        .newInstance(passwordRuleComponent);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        this.passwordRuleComponent = passwordRuleComponent;
    }

    public String isPasswordValid(String password) {
        return this.passwordRuleComponent.isPasswordValid(password);
    }

}
