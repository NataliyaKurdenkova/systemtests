package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PassingTestController {

    @GetMapping("/passing_test")
    public String getTestsPage(){
            return "passing_test";

    }
}
