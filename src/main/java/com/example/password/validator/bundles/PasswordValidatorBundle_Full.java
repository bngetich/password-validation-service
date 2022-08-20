package com.example.password.validator.bundles;

import com.example.password.validator.components.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * password validation bundle that applies length, character ontology, and character sequence validations
 */
@Component
public class PasswordValidatorBundle_Full extends PasswordValidatorBundle {

    private static final List<Class<? extends PasswordValidatorComponentDecorator>> PASSWORD_RULES_DECORATOR_LIST =
            Stream.of(PasswordHasLowerCaseComponent.class,
                    PasswordHasNumberComponent.class,
                    PasswordHasCorrectLengthComponent.class,
                    PasswordHasNoRepeatSequenceComponent.class
            ).collect(Collectors.toList());

    public PasswordValidatorBundle_Full() {
        super(PASSWORD_RULES_DECORATOR_LIST);
    }
}
