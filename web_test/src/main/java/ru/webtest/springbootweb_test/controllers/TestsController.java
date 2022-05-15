package ru.webtest.springbootweb_test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.entitys.*;
import ru.webtest.springbootweb_test.repositories.AnswerRepository;
import ru.webtest.springbootweb_test.repositories.AnswerUserRepository;
import ru.webtest.springbootweb_test.repositories.QuestionRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;
import ru.webtest.springbootweb_test.service.TestService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class TestsController {


    @Autowired
    private TestService testService;
    @Autowired
    private UserDetailsServiceImpl usersService;


    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public int i = 0;
    public int kolvoque = 0;
    public double correctAnswers = 0;
    public String login;
    public double k = 0;

    //начало теста
    public long startTime;
    //конец теста
    public long endTime;
    //время прохождения теста
    public long timeTest;
    public Attempt attempt;


    @Secured("ROLE_ADMIN")
    @GetMapping("/tests")
    public String getTestsPage(Model model) {
        login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "tests_page";

    }

    //прохождение теста
    @GetMapping("/pass_test/{idtest}")
    public String getQuestionsPage(@PathVariable("idtest") long idtest, Model model) {
        login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        Question[] question = testService.getQuestionByParent_Test(idtest);

        long nomer = question[i].getIdque();
        System.out.println("nomer voprosa" + nomer);
        System.out.println(question[i].getQuestion());
        System.out.println("ответы для вопроса №" + nomer);

        Answer[] answ = testService.getAnswerByParent_Question(nomer);
        k = testService.countballsCh(answ);
        System.out.println("количество баллов за правильный ответ " + k);
        model.addAttribute("idtest", idtest);
        model.addAttribute("question", question[i].getQuestion());
        model.addAttribute("answers", answ);
        return "passing_test";
    }

    //начало прохождения
    @PostMapping("/pass_test/{idtest}")
    public String QuestionsPage(@PathVariable("idtest") long idtest, Model model) {
        i = 0;
        startTime = System.currentTimeMillis();
        System.out.println("starttime " + startTime);
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);

        attempt = new Attempt();
        AnswerUser answerUser=new AnswerUser();
        Question[] questions = testService.getQuestionByParent_Test(idtest);

        //количество вопросов
        kolvoque = questions.length;
        System.out.println(i);
        System.out.println(questions[i].getIdque());
        System.out.println("ответы для вопроса " + questions[i].getQuestion());
        //номер вопроса
        long nomer = questions[i].getIdque();

        answerUser.setIdquestion(nomer);
        System.out.println("nomer voprosa " + nomer);
        //ответы
        System.out.println("ответы");

        Answer[] answ = testService.getAnswerByParent_Question(nomer);
        k = testService.countballsCh(answ);
        System.out.println("количество баллов за правильный ответ " + k);


        //добавляем на страницу
        model.addAttribute("idtest", idtest);
        model.addAttribute("question", questions[i].getQuestion());
        model.addAttribute("answers", answ);
        model.addAttribute("type", answ[i].getType());

        return "passing_test";

    }

    //кнопка пропустить
    @GetMapping("/skip/{idtest}")
    public String NextQuestion(@PathVariable("idtest") int idtest) {
        if (i >= kolvoque - 1) i = i;
        else i++;
        return "redirect:/pass_test/{idtest}";
    }

    //кнопка назад
    @GetMapping("/back/{idtest}")
    public String postQuestion(@PathVariable("idtest") int idtest) {
        if (i == 0) i = 0;
        else
            i--;
        return "redirect:/pass_test/{idtest}";
    }

    //кнопка завершить тест
    @GetMapping("/exit")
    public String exitTest() {
        endTime = System.currentTimeMillis();
        System.out.println("endTime " + endTime);
        i = 0;
        correctAnswers = 0;
        return "redirect:/lich_page";
    }


    //кнопка ответить
    @GetMapping("/answer/{idtest}")
    public String answerQuestion(@PathVariable("idtest") int idtest, @RequestParam String[] id, Model model) {
        Test test = testService.getTest(idtest);
        AnswerUser answerUser=new AnswerUser();
        //login = usersService.getCurrentUsername();
        model.addAttribute("name", login);


        if (i >= kolvoque-1) {
            i = i;
            System.out.println("Это был последний вопрос");

            for (int j = 0; j <= id.length-1; j++) {
                System.out.println("полученный ответ " + id);
                Answer answer = testService.getAnswerById(Long.valueOf(id[j]));
                answerUser.setIdanswer(Long.valueOf(id[j]));
                System.out.println("ответ: " + answer.getName());

                if (answer.getCorrect() == 1) {
                    System.out.println("выбран правильный ответ");
                    correctAnswers += k;
                } else System.out.println("Выбран не верный ответ");
                System.out.println("Количество правильных ответов " + correctAnswers);
                answerUser.setCorrect(answer.getCorrect());
               attempt.setAnswerUsers(Arrays.asList(answerUser));
            }

            System.out.println("balls " + correctAnswers);
            endTime = System.currentTimeMillis();
            System.out.println("endTime " + endTime);
            timeTest = endTime - startTime;
            // для подсчета времени прохождения теста
            System.out.println("timetest " + timeTest);
            long sek = (timeTest % 60000) / 1000;
            long min = timeTest / 60000;
            long chas = timeTest / 3600000;
            String timetestf = chas + ":" + min + ":" + sek;
            System.out.println(timetestf);

            //id  пользователя
            long iduser = usersService.getCurrentUserId();
            attempt.setIduser(iduser);
            int kolvoAttempt=testService.getAttemptUser(idtest,iduser);
            if(kolvoAttempt==0)kolvoAttempt=1;
            else kolvoAttempt++;
            attempt.setAttempt(kolvoAttempt);
            attempt.setTimeTest(timetestf);
            Date current = new Date();
            attempt.setCurrentDataTime(String.valueOf(current));
            attempt.setBalls(correctAnswers);
            attempt.setIdtest(idtest);
            attempt.setAnswerUsers(Arrays.asList(answerUser));
            //testService.saveResult(attempt,answerUser);
            //проверка результата
            if (correctAnswers >= test.getPassball()) {

                String msg = test.getName()+" СДАН! ";
                model.addAttribute("Msg", msg);
                System.out.println(msg);
            } else {
                String msg1 = test.getName()+" НЕ СДАН! ";
                model.addAttribute("Msg", msg1);
                System.out.println(msg1);
            }

            model.addAttribute("balls", correctAnswers);
            model.addAttribute("timetest", timetestf);

            i = 0;
            correctAnswers = 0;
            return "test_end";

        } else {

            for (int j = 0; j <= id.length-1; j++) {
                System.out.println("полученный ответ " + id);
                Answer answer = testService.getAnswerById(Long.valueOf(id[j]));

                answerUser.setIdanswer(Long.valueOf(id[j]));
                System.out.println("ответ: " + answer.getName());

                if (answer.getCorrect() == 1) {
                    System.out.println("выбран правильный ответ");
                    correctAnswers += k;
                } else System.out.println("Выбран не верный ответ");
                System.out.println("Количество правильных ответов " + correctAnswers);
                answerUser.setCorrect(answer.getCorrect());
                attempt.setAnswerUsers(Arrays.asList(answerUser));
            }
            i++;
            return "redirect:/pass_test/{idtest}";
        }

    }


    //начало теста
    @GetMapping("/start/{idtest}")
    public String getstartTest(@PathVariable("idtest") int idtest, Model model) {
        correctAnswers = 0;
        String login = usersService.getCurrentUsername();
        model.addAttribute("name", login);
        Test test = testService.getTest(idtest);
        String nametest = test.getName();
        model.addAttribute("test_name", nametest);
        int kolvo = test.getNeedque();
        model.addAttribute("kolvo", kolvo);
        int ball = test.getPassball();
        model.addAttribute("ball", ball);
        int time = test.getTime();
        model.addAttribute("time", time);
        return "test_start";
    }

    //кнопка пересдать тест
    @GetMapping("/restart/{idtest}")
    public String restartTest(@PathVariable("idtest") long idtest) {
        return "redirect:/start/{idtest}";
    }

    //кнопка вернуться на главную
    @GetMapping("/reslich_page")
    public String home() {
        return "redirect:/lich_page";
    }

    //кнопка посмотреть результат
    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("name", login);
        model.addAttribute("iduser", attempt.getIduser());
        model.addAttribute("idtest", attempt.getIdtest());
        model.addAttribute("timetest", attempt.getTimeTest());
        model.addAttribute("balls", attempt.getBalls());
        model.addAttribute("attempt", attempt.getAttempt());
        model.addAttribute("currenttime", attempt.getCurrentDataTime());

        return "result";
    }

}
