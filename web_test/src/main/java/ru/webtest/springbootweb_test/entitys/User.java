package ru.webtest.springbootweb_test.entitys;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id пользователя
    private Long iduser;
    //логин -email
    private String login;
    // хэш пароля- он сохраняется в базу и используется для входа
    private String hashPassword;
    //ФИО пользователя
    private String name;

    @ManyToMany
    @JoinTable (name = "account_x_tests",
            joinColumns = @JoinColumn (name = "iduser"),
    inverseJoinColumns = @JoinColumn(name = "idtest"))
    private List<Test> tests;


    //пароль, но мы его не сохраняем, а хэшируем
    @Transient
    private String password;
    @Transient
    private String passwordConfirm;



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



    // getters & setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
