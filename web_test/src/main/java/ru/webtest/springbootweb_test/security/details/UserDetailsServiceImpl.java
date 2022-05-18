package ru.webtest.springbootweb_test.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import java.util.Collections;
import java.util.stream.Collectors;


@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

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


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = usersRepository.findByLogin(login);
        if (user != null) {
            //return new UserDetailsImpl(user);
            return new  org.springframework.security.core.userdetails.User(user.getLogin(), user.getHashPassword(),
                         mapRolesToAuthorities(user.getRoles()));
        } else throw new UsernameNotFoundException("Такого пользователя нет");



    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public boolean saveUser(User user) {
        //проверка если такой пользователь в базе уже
          if ((usersRepository.findByLogin(user.getLogin()) != null)) {
            return false;
        }
              User usernew = new User();
              usernew.setLogin(user.getLogin());
              usernew.setName(user.getName());
              //получаем пароль из введенной формы и хешируем его
              usernew.setHashPassword(passwordEncoder.encode(user.getPassword()));
              //роль по умолчанию User
              Role role = roleRepository.findByName("ROLE_USER");
              usernew.setRoles(Collections.singleton(role));
              usersRepository.save(usernew);
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

    public long getCurrentUserId() {
        //получаем логин по которому пользователь авторизировался
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //ищем ФИО в репозитории по логину
        User user = usersRepository.findByLogin(auth.getName());
        //возвращаем id пользователя
        return user.getIduser();

    }

    //получение логина по номеру пользователя
    public String getUserName(long iduser){
        User user=usersRepository.findById(iduser);
        return user.getName();
    }

//изменение пароля
    public boolean savePasswordBD(String password,long iduser) {
        //проверка если такой пользователь в базе
        User user=usersRepository.findById(iduser);
        System.out.println(user.getLogin());
        if ((usersRepository.findById(iduser) == null)) {
            return false;
        }

        //получаем пароль из введенной формы и хешируем его
        user.setHashPassword(passwordEncoder.encode(password));
        usersRepository.save(user);
        return true;
    }
//редактирование пользователя
    public boolean saveUserBD(User user, String namerole, String hashpassword) {
        User usernew = new User();
        usernew.setIduser(user.getIduser());
        usernew.setLogin(user.getLogin());
        usernew.setName(user.getName());
        usernew.setHashPassword(hashpassword);
        System.out.println("hashpassword "+hashpassword);
        System.out.println("save "+ usernew.getName() );
        Role role = roleRepository.findByName(namerole);
        usernew.setRoles(Collections.singleton(role));
        usersRepository.save(usernew);
        return true;
    }

    public User getUser(long iduser){
         User user=usersRepository.findById(iduser);
         return user;
    }
public void deleteUser(long iduser){
        usersRepository.deleteById(iduser);
}

}
