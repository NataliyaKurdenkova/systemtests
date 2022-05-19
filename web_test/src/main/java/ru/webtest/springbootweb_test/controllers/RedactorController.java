package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.webtest.springbootweb_test.entitys.Answer;
import ru.webtest.springbootweb_test.entitys.Question;
import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.TestService;

import java.util.List;

@Controller
public class RedactorController {

    @Autowired
    private TestService testService;
    @Autowired
    private UserDetailsServiceImpl usersService;

    @GetMapping("/newtest")
    public String getNewTestPage(Model model){
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        //List<Question> questions = testService.getAllQuestions();
        //model.addAttribute("questions", questions);
        // List<Answer> answers = testService.getAllAnswers();
        //model.addAttribute("answers", answers);
        //long lastnomer=5;
        // System.out.println(testService.getNomerTest(tests.size()));
        // long lastnomer=testService.getNomerTest(tests.size());
        // lastnomer++;
        // model.addAttribute("idtest", lastnomer);

        return "newtest";
    }
}