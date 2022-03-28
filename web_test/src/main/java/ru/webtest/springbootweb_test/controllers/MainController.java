package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMainPage() {
        return "main";
    }

    @PostMapping("/reg")
    public String postReg() {
        return "registration";
    }

    @PostMapping("/entrance")
    public String reSignUp() {
        return "signIn";
    }
}
