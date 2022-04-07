package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.repositories.entitys.Answer;

@Repository
public interface AnswersRepository extends JpaRepository<Answer,Long> {
    Answer[] findAnswerByParent(long parent);
}
