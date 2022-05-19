package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.entitys.PrescPassedTests;
import ru.webtest.springbootweb_test.repositories.PrescPassedTestsRepository;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.TestService;


import java.util.List;

@Controller
public class LichController {
    @Autowired
    private UserDetailsServiceImpl usersService;
    @Autowired
    private TestService testService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TestsRepository testsRepository;
    @Autowired
    private PrescPassedTestsRepository prescPassedTestsRepository;

    @GetMapping("/lich_page")
    public String getLichPage( Model model)  {
        //получаем имя текущего пользователя
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);

        long iduser = usersService.getCurrentUserId();

        List<PrescPassedTests> prescPassedTests = testService.getPrescAndPassedTestsByUserId(iduser);

        long[] nomerpas=new long[1];
        int k=0;
        for (PrescPassedTests p:prescPassedTests) {
            nomerpas[k]=p.getIdpresc();
            k++;
        }

        List<Test> tests=testService.getTestPresc(nomerpas);
        model.addAttribute("tests", tests);
        return "lich_page";


    }

}
