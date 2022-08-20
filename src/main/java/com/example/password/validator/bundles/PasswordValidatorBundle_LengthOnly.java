package com.example.password.validator.bundles;


import com.example.password.validator.components.PasswordHasCorrectLengthComponent;
import com.example.password.validator.components.PasswordValidatorComponentDecorator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * password validation bundle that applies only a length validation
 */
@Component
public class PasswordValidatorBundle_LengthOnly extends PasswordValidatorBundle {

    private static final List<Class<? extends PasswordValidatorComponentDecorator>> PASSWORD_RULES_DECORATOR_LIST =
            Stream.of(
                    PasswordHasCorrectLengthComponent.class
            ).collect(Collectors.toList());


    public PasswordValidatorBundle_LengthOnly() {
        super(PASSWORD_RULES_DECORATOR_LIST);
    }

}
