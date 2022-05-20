package ru.webtest.springbootweb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.entitys.*;
import ru.webtest.springbootweb_test.repositories.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TestService {
    private TestsRepository testsRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private PrescTestsRepository prescTestsRepository;
    public AttemptRepository attemptRepository;

    private PassedTestsRepository passedTestsRepository;


    @Autowired
    public void setPrescPassedTestsRepository(PrescTestsRepository prescTestsRepository) {

        this.prescTestsRepository = prescTestsRepository;
    }

    @Autowired
    public void setPassedTestsRepository(PassedTestsRepository passedTestsRepository) {

        this.passedTestsRepository = passedTestsRepository;
    }

    @Autowired
    public void setTestsRepository(TestsRepository testsRepository) {

        this.testsRepository = testsRepository;
    }

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    @Autowired
    public void setAnswerRepository(AnswerRepository answersRepository) {
        this.answerRepository = answersRepository;

    }

    @Autowired
    public void setAttemptRepository(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;

    }


    //поиск вопроса по номеру теста
    public Question[] getQuestionByParent_Test(long parent) {
        return questionRepository.findQuestionsByParent(parent);
    }

    public Question getQuestionById(long id) {
        return questionRepository.findByIdque(id);
    }

    //для пролучения списка ответов
    public List<Answer> getNameAnswer(Long id) {
        List<Answer> list = answerRepository.findAll();
        return list;
    }

    //для поиска от ответов по номеру вопроса
    public Answer[] getAnswerByParent_Question(long parent) {
        //return answerRepository.findAnswerByParent(parent);
        return answerRepository.findAnswerByParent(parent);

    }


    //список всех тестов
    public List<Test> getAllTests() {
        return (List<Test>) (testsRepository.findAll());
    }

    //поиск теста по номеру
    public Test getTest(long idtest) {
        return testsRepository.findByIdtest(idtest);
    }


    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    public List<Question> getAllQuestions() {
        return (List<Question>) (questionRepository.findAll());
    }

    public List<Answer> getAllAnswers() {
        return (List<Answer>) (answerRepository.findAll());
    }



   /* public Attempt getAttemptByIdUserAndIdTest(long iduser, long idtest) {
      return attemptRepository.findAttemptByIduserAndIdtest(iduser,idtest);
    }
*/

    //для подсчета количества баллов за выбранный ответ - если тип ответа radio то он =1, а если тип chekbox,
// то все зависит от количества правильных ответов в впоросе
    public double countballsCh(Answer[] answers) {
        //балл за выбранный ответ
        double count;
        //количество правильных ответов по вопросу
        double kolvocorrectansw = 0;
        for (Answer a : answers) {
            if (a.getCorrect() == 1) kolvocorrectansw++;
        }
        count = (1 / kolvocorrectansw);
        System.out.println("kolvocorrectansw " + kolvocorrectansw);
        System.out.println("count " + count);
        return count;
    }

    //количество попыток
    public int getAttemptUser(long idtest, long iduser) {
        int kolvo;
        try {
            Attempt attempt = attemptRepository.findAttemptByIduserAndIdtest(iduser, idtest);
            kolvo = attempt.getAttempt();
        } catch (NullPointerException e) {
            kolvo = 0;
        }
        return kolvo;
    }

    //id попытки
    public long getAttemptId(long idtest, long iduser) {
        long idatt;
        try {
            Attempt attempt = attemptRepository.findAttemptByIduserAndIdtest(iduser, idtest);
            idatt = attempt.getId();
        } catch (NullPointerException e) {
            idatt = 0;
        }

        return idatt;

    }


    // сохранение результата теста
    public void saveResult(Attempt attempt) {
        //answerUserRepository.save(answerUser);

        attemptRepository.save(attempt);
    }

    //поиск теста по id юзера
    public List<PrescTests> getPrescTestsByUserId(long iduser) {
        return prescTestsRepository.findPrescTestsByIduser(iduser);
    }

    public List<PassedTests> getPassedTestsByUserId(long iduser) {
        return passedTestsRepository.findPassedTestsByIduser(iduser);
    }
    public Test getTestPresc(long idtest) {
        Test test = testsRepository.findByIdtest(idtest);
        return test;
    }


}


