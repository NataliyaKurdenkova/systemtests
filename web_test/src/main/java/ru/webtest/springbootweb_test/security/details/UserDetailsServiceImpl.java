package ru.webtest.springbootweb_test.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.UsersRepository;

@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       User user=usersRepository.findByLogin(login);
       if(user!=null){
           return new UserDetailsImpl(user);
       }else throw new UsernameNotFoundException("Такого пользователя нет");

    }
}
