package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webtest.springbootweb_test.repositories.entitys.User;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);//для авторизации для поиска по логину(почте)

    User findById(long iduser);//для выборки по номеру



}
