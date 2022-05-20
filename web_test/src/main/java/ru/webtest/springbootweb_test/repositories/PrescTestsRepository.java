package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.entitys.PrescTests;

import java.util.List;

@Repository
public interface PrescTestsRepository extends JpaRepository<PrescTests,Long> {
    List<PrescTests> findPrescTestsByIduser(long iduser);
    PrescTests findPrescTestsByIduserAndAndIdpresc(long iduser,long idtest);

}
