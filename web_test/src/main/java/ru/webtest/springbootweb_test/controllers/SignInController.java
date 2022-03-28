package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getSignIn(){
        return "signIn";
    }
    @PostMapping("/signIn")
    public String postSignIn(){
        return "lich_page";
    }

}
