package ru.webtest.springbootweb_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            System.out.println(request.toString());
            return "redirect:/adminka/statistic";
        } else {
            System.out.println(request.toString());
            return "redirect:/lich_page";
        }
    }
}