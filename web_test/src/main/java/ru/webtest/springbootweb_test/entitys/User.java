package ru.webtest.springbootweb_test.entitys;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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


    //@Column(name= "idrole")
    private Long idrole=3l;
    //пароль, но мы его не сохраняем, а хэшируем
    @Transient
    private String password;
}
