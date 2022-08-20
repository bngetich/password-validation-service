package com.example.password.validator;

import com.example.password.validator.bundles.PasswordValidatorBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswordValidatorController {

    @Autowired
    @Qualifier("passwordValidatorBundle_Full")
    private PasswordValidatorBundle passwordValidatorBundle;

    @RequestMapping("/validator")
    public List<String> validator(@RequestParam(value="password") String password) {
        PasswordValidator passwordValidator = new PasswordValidator(passwordValidatorBundle);

        List<String> validatorResults = passwordValidator.validate(password);

        return validatorResults;
    }


}
