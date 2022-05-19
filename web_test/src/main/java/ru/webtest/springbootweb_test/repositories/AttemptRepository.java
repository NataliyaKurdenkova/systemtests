package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.Attempt;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt,Long> {

    Attempt findAttemptByIduserAndIdtest(long iduser,long idtest);

//   List<Attempt> findAttemptByIduserAndIdtest(long iduser, long idtest);

    List<Attempt> findAttemptByIduserAndIdtest();
}