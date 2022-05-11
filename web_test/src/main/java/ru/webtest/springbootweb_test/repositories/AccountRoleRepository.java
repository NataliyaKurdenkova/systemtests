package ru.webtest.springbootweb_test.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.entitys.Role;

public interface AccountRoleRepository extends JpaRepository<User,Long> {




}