package ru.webtest.springbootweb_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.webtest.springbootweb_test.repositories.entitys.Answer;
import ru.webtest.springbootweb_test.repositories.entitys.Question;
import ru.webtest.springbootweb_test.repositories.entitys.Test;
import ru.webtest.springbootweb_test.repositories.AnswersRepository;
import ru.webtest.springbootweb_test.repositories.QuestionsRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestsController {

    @Autowired
    private TestsRepository testsRepository;
    @Autowired
    private AnswersRepository answersRepository;
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private TestService testService;


    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    //List<Answer> answers=answersRepository.findAll();;
    //List<Question> questions=questionsRepository.findAll();;
    // private int indexq=0;


    @GetMapping("/tests")
    public String getTestsPage(Model model) {
        List<Test> tests = testsRepository.findAll();

        model.addAttribute("tests", tests);
        return "tests_page";

    }

    @PostMapping("/pass_test/{idtest}")
    public String getQuestionsPage(@PathVariable("idtest") int idtest, Model model) {

        Question[] question = testService.getQuestionByParent_Test((long) idtest);
        System.out.println(question[0].getQuestion());
        System.out.println(question[1].getQuestion());
        System.out.println("ответы для вопроса №" +question[0].getIdque());
        Answer[] answers = testService.getAnswerByParent_Question((long)1);
       /* List<String> answ= new ArrayList<>();
        for (int i=0;i<=(answers.length-1);i++) {
            answ.add(answers[i].getName());
        }
*/
        model.addAttribute("idtest", idtest);
        model.addAttribute("question", question[0].getQuestion());
        model.addAttribute("answers", answers);
        return "passing_test";

    }

    @PostMapping("/answer")
    public String getNextQuesrtion(@PathVariable("idtest") int idtest) {

        return "redirect:passing_test";
    }

}
