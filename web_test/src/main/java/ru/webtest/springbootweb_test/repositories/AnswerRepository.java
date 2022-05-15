package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.Answer;
import ru.webtest.springbootweb_test.entitys.Question;

import java.util.Collection;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
        Answer[] findAnswerByParent(long parent);


}
