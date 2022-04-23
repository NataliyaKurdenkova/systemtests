package ru.webtest.springbootweb_test.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.entitys.User;
import ru.webtest.springbootweb_test.repositories.RoleRepository;
import ru.webtest.springbootweb_test.repositories.UsersRepository;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = usersRepository.findByLogin(login);
        if (user != null) {
            //return new UserDetailsImpl(user);
            return new  org.springframework.security.core.userdetails.User(user.getLogin(), user.getHashPassword(),
                         mapRolesToAuthorities(user.getRoles()));
        } else throw new UsernameNotFoundException("Такого пользователя нет");

       // return new  org.springframework.security.core.userdetails.User(user.getLogin(), user.getHashPassword(),
         //       mapRolesToAuthorities(user.getRoles()));

    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public boolean saveUser(User usernew) {
        //проверка если такой пользователь в базе уже

        if ((usersRepository.findByLogin(usernew.getLogin()) != null)) {
            return false;
        }

        User user = new User();
        user.setLogin(usernew.getLogin());
        user.setName(usernew.getName());

       user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        //получаем пароль из введенной формы и хешируем его
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));

        usersRepository.save(user);

        long id = user.getIduser();
        System.out.println(id);


        return true;
    }

    //метод получает текущего пользователя, который авторизировался и подтягивает его на страницу на страницу пользователя его ФИО
    public String getCurrentUsername() {
        //получаем логин по которому пользователь авторизировался
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //ищем ФИО в репозитории по логину
        User user = usersRepository.findByLogin(auth.getName());
        //возвращаем ФИО
        return user.getName();

    }


    @Autowired
    public void setUserRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    @Transactional
//    public User findByLogin(String username) {
//        return usersRepository.findByLogin(username);
//    }

}
