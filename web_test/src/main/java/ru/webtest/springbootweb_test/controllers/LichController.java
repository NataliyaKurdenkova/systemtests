package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import ru.webtest.springbootweb_test.repositories.entitys.Test;
import ru.webtest.springbootweb_test.service.TestService;
import ru.webtest.springbootweb_test.service.UsersService;


import java.util.List;

@Controller
public class LichController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private TestService testService;


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TestsRepository testsRepository;

    @GetMapping("/lich_page")
    public String getLichPage( Model model)  {
        String login = "Иванов Иван Иванович";

        List<Test> tests = testsRepository.findAll();
        model.addAttribute("name", login);
        model.addAttribute("tests", tests);
        return "lich_page";
    }


}
