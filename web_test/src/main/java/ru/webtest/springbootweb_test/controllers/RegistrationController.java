package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(User user){
       //проверка. что поля не пустые и логин/почта содержит символы "@" и "."
        if((user.getLogin()!="")&(user.getPassword()!="")&(user.getName()!=""&(user.getLogin().contains("@"))&(user.getLogin().contains(".")))){
            //получаем пароль из введенной формы и хешируем его
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "main";}
        else return "registration";
    }
}

