package ru.webtest.springbootweb_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.webtest.springbootweb_test.entitys.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String theRoleName);
}
