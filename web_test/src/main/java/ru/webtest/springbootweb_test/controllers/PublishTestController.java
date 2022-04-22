package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublishTestController {


    @GetMapping("/publish/N")
    public String getNewTest(Model model) {
        return null;
    }
}