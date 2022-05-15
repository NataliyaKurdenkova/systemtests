package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    //id пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    //логин -email
    private String login;
    // хэш пароля- он сохраняется в базу и используется для входа
    private String hashPassword;
    //ФИО пользователя
    private String name;

    //пароль, но мы его не сохраняем, а хэшируем
    @Transient
    private String password;
    @Transient
    private String passwordConfirm;

    public Collection<Role> getRoles() {
        return roles;
    }

    //роли
    @ManyToMany
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idrole"))
    private Collection<Role> roles;


    public User(String login, String hashPassword, String name, Collection<Role> roles) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.name = name;
        this.roles = roles;
    }
    public User(String login, String hashPassword, String name) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.name = name;

    }

    public String getRolesUser(){
        //если роль одна, то пока так, потом переделать
        String roleuser=null;
        for(Role r:roles){
            roleuser=r.getName();}
        return roleuser;
    }

}
