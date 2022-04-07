package ru.webtest.springbootweb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.repositories.AnswersRepository;
import ru.webtest.springbootweb_test.repositories.QuestionsRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.repositories.entitys.Answer;
import ru.webtest.springbootweb_test.repositories.entitys.Question;
import ru.webtest.springbootweb_test.repositories.entitys.Test;

import java.util.List;

@Service
public class TestService {
    private TestsRepository testsRepository;
    private QuestionsRepository questionsRepository;
    private AnswersRepository answersRepository;

    @Autowired
    public void setTestsRepository(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }
    @Autowired
    public void setQuestionsRepository(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;

    }
    @Autowired
    public void setAnswersRepository(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;

    }

    public List<Test> getAllTests() {
        return (List<Test>)(testsRepository.findAll());
    }

    public Test getTestById(Long id) {
        return testsRepository.findById(id).orElse(null);
    }

    public List<Question> getAllQuestions() {
        return (List<Question>)(questionsRepository.findAll());
    }

    public Question[] getQuestionByParent_Test(Long id) {
        return questionsRepository.findQuestionsByParent((long)id);
    }
    public List<Answer> getAllAnswers() {
        return (List<Answer>)(answersRepository.findAll());
    }

    public Answer getAnswerById(Long id) {
        return answersRepository.findById(id).orElse(null);
    }
    public Answer[] getAnswerByParent_Question(Long id) {
        return answersRepository.findAnswerByParent((long)id);
    }
}


