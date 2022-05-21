package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    private String currentTestId; // при открытии страницы newtest присваивается номер последнего теста
    private String currentQuestionId; // при открытии страницы newtest присваивается номер последнего вопроса
    private int correct; // правильный или неправильный этот ответ на вопрос


    @GetMapping("/newtest")
    public String getNewTestPage(Model model){
        String login = usersService.getCurrentUsername();
       model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
       model.addAttribute("tests", tests);

        List<Question> questions = testService.getAllQuestions();
        model.addAttribute("questions", questions);
        currentQuestionId = String.valueOf(questions.size());
        List<Answer> answers = testService.getAllAnswers();
        model.addAttribute("answers", answers);
        System.out.println(tests.size());
        currentTestId = String.valueOf(tests.size());
        model.addAttribute("idtest", currentTestId);


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



    @GetMapping("/newt/{int}")
    public String getNewTestPageWithTestNumber(@PathVariable(value = "int") String id, Model model){
        System.out.println("currentTestId = " + currentTestId);
        currentTestId = id;
        System.out.println("currentTestId = " + currentTestId);

        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);



        List<Question> questions = testService.getAllQuestions();
        model.addAttribute("questions", questions);
        currentQuestionId = String.valueOf(questions.size());
        List<Answer> answers = testService.getAllAnswers();
        model.addAttribute("answers", answers);
        System.out.println(tests.size());
        model.addAttribute("idtest", Integer.parseInt(currentTestId));
        System.out.println(testService.getAllTests());

        return "newtest";
    }

    @PostMapping("/newtest")
    public String addTest(Model model, String addTest) {
        System.out.println(addTest);
        List<Test> tests = testService.getAllTests();
        currentTestId = String.valueOf((tests.size()+1));

        int newPassball = 0,
                totalque = 0,
                newNeedQue = 0,
                newTime = 0;

        testService.addTest(new Test(Long.parseLong(currentTestId), addTest, newPassball, totalque, newNeedQue, newTime));
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        model.addAttribute("tests", tests);
        List<Question> questions = testService.getAllQuestions();
        model.addAttribute("questions", questions);
        currentQuestionId = String.valueOf(questions.size());
        List<Answer> answers = testService.getAllAnswers();
        model.addAttribute("answers", answers);
        System.out.println(tests.size());
        model.addAttribute("idtest", currentTestId);
        currentTestId = String.valueOf(tests.size());
        return "newtest";
    }

    @PostMapping("/addquestion")
    public String addQuestion(Model model, String addquestion){

        System.out.println(addquestion);

        List<Question> questions = testService.getAllQuestions();
        currentQuestionId = String.valueOf((questions.size())+1);
        testService.addQuestion(new Question(Long.parseLong(currentQuestionId), addquestion, Integer.parseInt(currentTestId)));

        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);

        model.addAttribute("questions", questions);
        List<Answer> answers = testService.getAllAnswers();
        model.addAttribute("answers", answers);
        System.out.println(tests.size());
        model.addAttribute("idtest", currentTestId);
        System.out.println(testService.getAllTests());

        return "newtest";
    }

    @GetMapping("/newq/{int}")
    public String getNewTestPageWithQuetionNumber(@PathVariable(value = "int") String id, Model model){
        System.out.println("currentQuestionId = " + currentQuestionId);
        currentQuestionId = id;
        System.out.println("currentQuestionId = " + currentQuestionId);

        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        List<Question> questions = testService.getAllQuestions();
        model.addAttribute("questions", questions);
        List<Answer> answers = testService.getAllAnswers();
        model.addAttribute("answers", answers);
        System.out.println(tests.size());
        model.addAttribute("idtest", Integer.parseInt(currentTestId));
        System.out.println(testService.getAllTests());

        return "newtest";
    }



    @PostMapping("/addAnswer")
    public void addAnswer(String answers, int correct, String type){

        long answerSize=testService.getAllAnswers().size();

        for (String answer : answers.split(",(?!\\s)"))
        {
            if (!answer.equals("")) {
                answerSize++;
                testService.addAnswer(new Answer(answerSize, answer,  0, //correct
                        Integer.parseInt(currentQuestionId),type));

            }
        }

    }

}
