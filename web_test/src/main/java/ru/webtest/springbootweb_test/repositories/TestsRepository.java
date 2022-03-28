package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webtest.springbootweb_test.entitys.Test;

public interface TestsRepository extends JpaRepository<Test,Long> {
}
