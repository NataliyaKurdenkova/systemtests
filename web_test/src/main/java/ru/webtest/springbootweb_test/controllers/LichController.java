package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LichController {
    @GetMapping("/lich_page")
    public String getLichPage(){
        return "lich_page";
    }
}
