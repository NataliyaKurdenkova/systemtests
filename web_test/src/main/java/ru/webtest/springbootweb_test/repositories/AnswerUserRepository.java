package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.AnswerUser;

@Repository
public interface AnswerUserRepository extends JpaRepository<AnswerUser,Long> {



}