package ru.webtest.springbootweb_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.webtest.springbootweb_test.entitys.Attempt;
import ru.webtest.springbootweb_test.entitys.AttemptView;
import ru.webtest.springbootweb_test.entitys.PassedTests;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.AttemptService;
import ru.webtest.springbootweb_test.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PassedTestsController {


    @Autowired
    private UserDetailsServiceImpl usersService;
    @Autowired
    private TestService testService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AttemptService attemptService;


    @GetMapping("/passedtests")
    public String getPassedTestsPage(Model model) {
        //получаем имя текущего пользователя
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        long iduser = usersService.getCurrentUserId();
        List<PassedTests> passedTests = testService.getPassedTestsByUserId(iduser);
        List<Attempt> attempts=new ArrayList<>();
        for (PassedTests p : passedTests) {
            attempts.add(attemptService.getAttemptByOneIduserAndIdtest(iduser,p.getIdpassed()));
        }
        List<AttemptView> attemptViews=attemptService.getAttemptViewByOneIduserAndIdtest(attempts);

        model.addAttribute("attempts", attemptViews);
        return "passedtests";
    }


}
