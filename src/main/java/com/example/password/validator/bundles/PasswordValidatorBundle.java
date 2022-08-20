package com.example.password.validator.bundles;

import com.example.password.validator.components.PasswordNotEmptyComponent;
import com.example.password.validator.components.PasswordValidatorComponent;
import com.example.password.validator.components.PasswordValidatorComponentDecorator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * base for all PasswordValidatorBundles. this is here to save the engineer the need to manually compose
 * decorated PasswordValidatorComponents. A 'bundle' class is really just a list containing the desired
 * PasswordValidatorComponent classes that uses this class's constructor to create a PasswordValidatorComponent
 * object decorated with whatever the engineer wants.
 */
public abstract class PasswordValidatorBundle {

    private final PasswordValidatorComponent passwordValidatorComponent;
    public final List<Class<? extends PasswordValidatorComponentDecorator>> passwordRuleDecoratorList;

    protected PasswordValidatorBundle(List<Class<? extends PasswordValidatorComponentDecorator>> passwordRuleDecoratorList) {
        PasswordValidatorComponent passwordValidatorComponent = new PasswordNotEmptyComponent(); //concrete component
        this.passwordRuleDecoratorList = passwordRuleDecoratorList;

        for (Class<? extends PasswordValidatorComponentDecorator> passwordRuleDecoratorClazz : this.passwordRuleDecoratorList){

            try{
                passwordValidatorComponent = passwordRuleDecoratorClazz.getConstructor(PasswordValidatorComponent.class)
                        .newInstance(passwordValidatorComponent);
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

        this.passwordValidatorComponent = passwordValidatorComponent;
    }

    public void isPasswordValid(String password) {
        this.passwordValidatorComponent.isPasswordValid(password);
    }

}
