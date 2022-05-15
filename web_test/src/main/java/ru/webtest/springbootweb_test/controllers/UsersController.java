package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;

import java.util.Collection;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserDetailsServiceImpl usersService;

   @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public String getUsersPage(Model model){

        //получаем имя текущего пользователя
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);

        List<User> users =usersRepository.findAll();
        model.addAttribute("users",users);

        return "users_page";
    }

}
