package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.AccountRoleRepository;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.UsersService;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository rolesRepository;
    @Autowired
    private AccountRoleRepository arRepository;

    @Autowired
    private UserDetailsServiceImpl usersService;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(User user) {
        //проверка. что поля не пустые и логин/почта содержит символы "@" и "."
        if ((user.getLogin() != "") & (user.getPassword() != "") & (user.getName() != "" & (user.getLogin().contains("@")) & (user.getLogin().contains(".")))) {
            //Проверка паролей
            if (!user.getPassword().equals(user.getPasswordConfirm())) {
                System.out.println("Пароли не совпадают");
                return "registration";
            }

           //сохраняем пользователя
            usersService.saveUser(user);

            if (!usersService.saveUser(user)){
                System.out.println("Пользователь не добавлен");
                return "registration";
            }
            System.out.println("Пользователь добавлен");
            return "main";
        } else return "registration";
    }
}

