package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import ru.webtest.springbootweb_test.repositories.entitys.User;

@Controller
public class SignInController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/signIn")
    public String getSignIn() {
        System.out.println("Переход на страницу ВХОД");
        return "signIn";
    }

    @PostMapping("/signIn")
    public String postSignIn(Model model) {
        System.out.println("Переход на страницу Lichpage");
        //model.addAttribute("name",login);
        return "lich_page";
    }

}




