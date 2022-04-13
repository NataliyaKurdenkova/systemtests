package ru.webtest.springbootweb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.repositories.AnswerRepository;

import ru.webtest.springbootweb_test.repositories.QuestionRepository;

import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.repositories.entitys.Answer;
import ru.webtest.springbootweb_test.repositories.entitys.Question;
import ru.webtest.springbootweb_test.repositories.entitys.Test;

import java.util.List;

@Service
public class TestService {
    private TestsRepository testsRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

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


    //поиск вопроса по номеру теста
    public Question[] getQuestionByParent_Test(int parent) {

        return questionRepository.findQuestionsByParent(parent);
    }

    //для пролучения списка ответов
    public List<Answer> getNameAnswer(Long id) {
        List<Answer> list = answerRepository.findAll();
        return list;
    }

    //для поиска от ответов по номеру вопроса
    public Answer[] getAnswerByParent_Question(int parent) {
        //List<Answer> list = answerRepository.findAnswerByParent(parent);
        Answer[] list=answerRepository.findAnswersByParent(parent);
        return list;
    }

    //список всех тестов
    public List<Test> getAllTests() {
        return (List<Test>) (testsRepository.findAll());
    }

//    public Test getTestById(Long id) {
//        return testsRepository.findById(id).orElse(null);
//    }
//
//    public List<Question> getAllQuestions() {
//        return (List<Question>) (questionsRepository.findAll());
//    }

//
//    public List<Answer> getAllAnswers() {
//        return (List<Answer>) (answersRepository.findAll());
//    }
//
//    public Answer getAnswerById(Long id) {
//        return answersRepository.findById(id).orElse(null);
//    }


}


