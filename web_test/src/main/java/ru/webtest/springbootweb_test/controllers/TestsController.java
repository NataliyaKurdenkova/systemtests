package ru.webtest.springbootweb_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.repositories.AnswerRepository;
import ru.webtest.springbootweb_test.entitys.Answer;
import ru.webtest.springbootweb_test.entitys.Question;
import ru.webtest.springbootweb_test.entitys.Test;
import ru.webtest.springbootweb_test.repositories.QuestionRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.service.TestService;
import ru.webtest.springbootweb_test.service.UsersService;

import java.util.List;

@Controller
public class TestsController {
    int i=0;
    @Autowired
    private TestsRepository testsRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestService testService;
    @Autowired
    private UsersService usersService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/tests")
    public String getTestsPage(Model model) {
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "tests_page";

    }

    @GetMapping("/pass_test/{idtest}")
    public String getQuestionsPage(@PathVariable("idtest") int idtest, Model model) {
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        Question[] question = testService.getQuestionByParent_Test(idtest);
        System.out.println(question[i].getQuestion());
        System.out.println("ответы для вопроса №" + question[i].getIdque());
        int nomer=question[i].getIdque().intValue();
        System.out.println("nomer voprosa"+nomer);
        Answer[] answ = testService.getAnswerByParent_Question(nomer);

        model.addAttribute("idtest", idtest);
        model.addAttribute("question", question[i].getQuestion());
        model.addAttribute("answers", answ);
        return "passing_test";
    }

    @PostMapping("/pass_test/{idtest}")
    public String QuestionsPage(@PathVariable("idtest") int idtest, Model model) {

        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        Question[] question = testService.getQuestionByParent_Test(idtest);
        System.out.println(question[i].getQuestion());
        System.out.println("ответы для вопроса №" + question[i].getIdque());
        int nomer=question[i].getIdque().intValue();
        System.out.println("nomer voprosa"+nomer);
        Answer[] answ = testService.getAnswerByParent_Question(nomer);

        model.addAttribute("idtest", idtest);
        model.addAttribute("question", question[i].getQuestion());
        model.addAttribute("answers", answ);
        return "passing_test";

    }

    @PostMapping("/answer")
    public String getNextQuestionAndAnswer(@PathVariable("idtest") int idtest) {

        return "redirect:passing_test";
    }


    @PostMapping("/skip/{idtest}")
    public String NextQuestion(@PathVariable("idtest") int idtest, Model model) {
        i++;
        System.out.println(i);
        return "redirect:/pass_test/{idtest}";
    }

    @PostMapping("/back/{idtest}")
    public String postQuestion(@PathVariable("idtest") int idtest, Model model) {
        i--;
        System.out.println(i);
        return "redirect:/pass_test/{idtest}";
    }
}
