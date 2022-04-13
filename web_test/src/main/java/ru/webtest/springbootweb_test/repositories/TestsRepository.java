package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.Test;

@Repository
public interface TestsRepository extends JpaRepository<Test,Long> {
}
