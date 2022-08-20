package com.example.password.validator;

import com.example.password.validator.bundles.PasswordValidatorBundle_Full;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PasswordValidationBundleFullTest {

    private final PasswordValidatorBundle_Full fullValidatorBundle = new PasswordValidatorBundle_Full();

    private final PasswordValidator passwordValidator = new PasswordValidator(fullValidatorBundle);
    @Test
    void should_test_invalid_length(){
        //given
        String passwordTooShort = "bk29";

        //when
        List<String> validatorResult = passwordValidator.validate(passwordTooShort);

        //then
        assertTrue(validatorResult.contains("Password must be between 5 and 12 characters in length"));
    }

    @Test
    void should_test_missing_case(){

        //given
        String passwordMissingLowerCase = "BK2384";

        //when
        List<String> validatorResult = passwordValidator.validate(passwordMissingLowerCase);

        //then
        assertTrue(validatorResult.contains("Password must contain at least one lowercase character"));
    }

    @Test
    void should_test_missing_number(){

        //given
        String passwordMissingNumber = "BKndjsd";

        //when
        List<String> validatorResult = passwordValidator.validate(passwordMissingNumber);

        //then
        assertTrue(validatorResult.contains("Password must contain at least one numeric character"));
    }

    @Test
    void should_test_invalid_character_sequence(){

        //given
        String passwordInvalidCharacterSequence = "bkn123123";

        //when
        List<String> validatorResult = passwordValidator.validate(passwordInvalidCharacterSequence);

        //then
        assertTrue(validatorResult.contains("Password must not contain any sequence of characters immediately followed by the same sequence"));
    }

}
