package ru.webtest.springbootweb_test.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class UsersService {


    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UsersRepository usersRepository;

  /*   @Resource()
    private SessionFactory sessionFactory;

   @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsersList() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) usersRepository.findAll();
    }

    public String getUsersFindById(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user.getName();
    }
*/



}




