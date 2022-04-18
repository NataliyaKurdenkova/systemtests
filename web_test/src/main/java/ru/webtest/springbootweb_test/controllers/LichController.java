package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import ru.webtest.springbootweb_test.entitys.Test;
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
        //получаем имя текущего пользователя
        String login = usersService.getCurrentUsername();

        model.addAttribute("name", login);
        List<Test> tests = testsRepository.findAll();

        model.addAttribute("tests", tests);
        return "lich_page";
    }


}
