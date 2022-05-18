package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.PrescPassedTests;

import java.util.List;

@Repository
public interface PrescPassedTestsRepository extends JpaRepository<PrescPassedTests,Long> {
    List<PrescPassedTests> findPrescPassedTestsByIduser(long iduser);
}
