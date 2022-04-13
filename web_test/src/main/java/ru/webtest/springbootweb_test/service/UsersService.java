package ru.webtest.springbootweb_test.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.webtest.springbootweb_test.repositories.entitys.User;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Resource()
   private SessionFactory sessionFactory;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsersList() {

       Session session = sessionFactory.getCurrentSession();
        return (List<User>)usersRepository.findAll();
    }

   public String getUsersFindById(long id) {
        Session session = sessionFactory.getCurrentSession();

        User user = (User) session.get(User.class, id);

        return user.getName();
        //return user;
    }


    //метод получает текущего пользователя, который авторизировался и подтягивает его на страницу на страницу пользователя его ФИО
    public String getCurrentUsername() {
        //получаем логин по которому пользователь авторизировался
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //ищем ФИО в репозитории по логину
        User user=usersRepository.findByLogin(auth.getName());
        //возвращаем ФИО
        return user.getName();

    }

}
