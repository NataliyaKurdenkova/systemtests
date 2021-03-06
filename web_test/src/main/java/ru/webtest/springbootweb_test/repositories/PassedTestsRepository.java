package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.PassedTests;

import java.util.List;

@Repository
public interface PassedTestsRepository extends JpaRepository<PassedTests,Long> {
    List<PassedTests> findPassedTestsByIduser(long iduser);

}
