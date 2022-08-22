package com.example.password.validator;

import com.example.password.validator.service.PasswordValidatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PasswordValidationBundleFullTest {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    @Test
    void should_test_invalid_length(){
        //given
        String passwordTooShort = "bk29";

        //when
        List<String> validatorResult = passwordValidatorService.validate(passwordTooShort);

        //then
        assertTrue(validatorResult.contains("Password must be between 5 and 12 characters in length"));
    }

    @Test
    void should_test_missing_case(){

        //given
        String passwordMissingLowerCase = "BK2384";

        //when
        List<String> validatorResult = passwordValidatorService.validate(passwordMissingLowerCase);

        //then
        assertTrue(validatorResult.contains("Password must contain at least one lowercase character"));
    }

    @Test
    void should_test_missing_number(){

        //given
        String passwordMissingNumber = "BKndjsd";

        //when
        List<String> validatorResult = passwordValidatorService.validate(passwordMissingNumber);

        //then
        assertTrue(validatorResult.contains("Password must contain at least one numeric character"));
    }

    @Test
    void should_test_invalid_character_sequence(){

        //given
        String passwordInvalidCharacterSequence = "bkn123123";

        //when
        List<String> validatorResult = passwordValidatorService.validate(passwordInvalidCharacterSequence);

        //then
        assertTrue(validatorResult.contains("Password must not contain any sequence of characters immediately followed by the same sequence"));
    }

}
