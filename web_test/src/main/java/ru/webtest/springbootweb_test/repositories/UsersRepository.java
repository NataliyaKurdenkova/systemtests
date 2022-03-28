package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.webtest.springbootweb_test.entitys.User;


public interface UsersRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);

}
