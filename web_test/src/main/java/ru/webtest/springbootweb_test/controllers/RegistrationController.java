package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(User user){
        usersRepository.save(user);
        return "main";
    }
}

