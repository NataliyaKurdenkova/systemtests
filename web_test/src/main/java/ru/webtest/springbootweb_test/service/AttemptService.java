package ru.webtest.springbootweb_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.entitys.*;
import ru.webtest.springbootweb_test.repositories.AnswerRepository;
import ru.webtest.springbootweb_test.repositories.AttemptRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

import java.util.*;

@Service
public class AttemptService {

    private AttemptRepository attemptRepository;
    private TestsRepository testsRepository;
    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    public void setAttemptRepository(AttemptRepository attemptRepository) {

        this.attemptRepository = attemptRepository;
    }

    @Autowired
    public void setTestsRepository(TestsRepository testsRepository) {

        this.testsRepository = testsRepository;
    }


    //для отображения на стр статистика (нужны не id. а имя и название теста)
    public List<AttemptView> getAttemptAll() {

        List<Attempt> attempts = attemptRepository.findAll();
        List<AttemptView> attemptViews = new ArrayList<>();
        for (Attempt a : attempts) {
            long iduser = a.getIduser();
            User user = usersRepository.findById(iduser);
            Test test = testsRepository.findByIdtest(a.getIdtest());
            AttemptView attemptView = new AttemptView(a.getId(), user.getName(), test.getName(), a.getAttempt(), a.getCurrentDataTime(), a.getBalls(), a.getTimeTest());
            attemptViews.add(attemptView);
        }
        if (attemptViews.isEmpty()) {
            AttemptView attemptView = new AttemptView(1l, "0", "0", 0, "0", 0, "0");
            attemptViews.addAll((Collection<? extends AttemptView>) attemptView);
        }
        return attemptViews;
    }

    // для отображения на стр /passedtest , вывод по названию теста
    public Attempt getAttemptByOneIduserAndIdtest(long iduser, long idtest) {

        Attempt attempt = attemptRepository.findAttemptByIduserAndIdtest(iduser, idtest);
        List<AttemptView> attemptViews = new ArrayList<>();
        return attempt;
    }

    // для отображения на стр /passedtest , вывод по названию теста
    public List<AttemptView> getAttemptViewByOneIduserAndIdtest(List<Attempt> attempts) {

        List<AttemptView> attemptViews = new ArrayList<>();
        for (Attempt a : attempts) {
            long iduser = a.getIduser();
            User user = usersRepository.findById(iduser);
            Test test = testsRepository.findByIdtest(a.getIdtest());
            AttemptView attemptView = new AttemptView(a.getIdtest(), user.getName(), test.getName(), a.getAttempt(), a.getCurrentDataTime(), a.getBalls(), a.getTimeTest());
            attemptViews.add(attemptView);
        }
        if (attemptViews.isEmpty()) {
            AttemptView attemptView = new AttemptView(0l, "0", "0", 0, "0", 0, "0");
            attemptViews.addAll((Collection<? extends AttemptView>) attemptView);
        }
        return attemptViews;
    }


// поиск по пользователю
    public List<Attempt> getAttemptByIdUser(long iduser) {

        List<Attempt> attempts = attemptRepository.findAttemptByIduser(iduser);

        return attempts;
    }

    //удаление
    public void deleteAttemptByIdUser(Attempt attempt) {
       attemptRepository.delete(attempt);
    }

}

