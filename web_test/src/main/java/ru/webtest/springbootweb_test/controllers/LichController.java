package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.entitys.Attempt;
import ru.webtest.springbootweb_test.entitys.PrescTests;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;

import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.AttemptService;
import ru.webtest.springbootweb_test.service.TestService;


import java.util.ArrayList;
import java.util.List;

@Controller
public class LichController {
    @Autowired
    private UserDetailsServiceImpl usersService;
    @Autowired
    private TestService testService;


    @GetMapping("/lich_page")
    public String getLichPage( Model model)  {
        //получаем имя текущего пользователя
        String login = usersService.getCurrentUsername();
        long iduser = usersService.getCurrentUserId();
        model.addAttribute("name", login);
       // List<Test> tests = testsRepository.findAll();

        List<PrescTests> prescPassedTests = testService.getPrescTestsByUserId(iduser);
        List<Test> tests=new ArrayList<>();
        for (PrescTests p:prescPassedTests) {
            tests.add(testService.getTestPresc(p.getIdpresc()));

        }
       // List<Attempt> attempts=new ArrayList<>();

        model.addAttribute("tests", tests);

        return "lich_page";
    }

}
