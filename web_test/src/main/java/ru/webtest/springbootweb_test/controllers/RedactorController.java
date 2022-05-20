package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.webtest.springbootweb_test.entitys.*;
import ru.webtest.springbootweb_test.repositories.PrescTestsRepository;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.TestService;

import java.util.List;

@Controller
public class RedactorController {

    @Autowired
    private TestService testService;
    @Autowired
    private UserDetailsServiceImpl usersService;
    @Autowired
    private PrescTestsRepository prescTestsRepository;
    public PrescTests prescTests;


    @GetMapping("/newtest")
    public String getNewTestPage(Model model){
        String login = usersService.getCurrentUsername();
       model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
       model.addAttribute("tests", tests);
       return "newtest";
    }



    // вывести список пользователей
    @GetMapping("/redactor_page")
    public String getUsersList (Model model) {
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);

        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);

        return "redactor_page";
    }


    // назначить тест
    @GetMapping("/prescribeuser/{iduser}")
    public String testShow(@PathVariable("iduser") long iduser, Model model) {
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        prescTests= new PrescTests();
        prescTests.setIduser(iduser);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "prescribe_test";
    }

    // назначить тест
    @GetMapping("/prescribetest/{idtest}")
    public String prescribeTest (@PathVariable("idtest") long idtest, Model model) {
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        prescTests.setIdpresc(idtest);
        prescTestsRepository.save(prescTests);
        return "redirect:/redactor_page";
    }

}
