package com.example.password.validator.controller;

import com.example.password.validator.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Has the /validator endpoint and injects our password validator service.
 * Request scoped meaning with each request a new controller instance is created.
 */
@RestController
@Scope("request")
public class PasswordValidatorController {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    @RequestMapping("/validator")
    public List<String> validator(@RequestParam(value="password") String password) {
        List<String> validatorResults = passwordValidatorService.validate(password);
        return validatorResults;
    }


}
