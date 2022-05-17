package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.Attempt;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempt,Long> {
    Attempt findAttemptByIduserAndIdtest(long iduser,long idtest);




}