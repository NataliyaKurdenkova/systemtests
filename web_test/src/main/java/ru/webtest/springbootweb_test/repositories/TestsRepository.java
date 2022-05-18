package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.Test;

import java.util.List;

@Repository
public interface TestsRepository extends JpaRepository<Test,Long> {
    Test findByIdtest(long idtest);




}