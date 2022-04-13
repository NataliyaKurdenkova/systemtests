package ru.webtest.springbootweb_test.entitys;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

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


    //@Column(name= "idrole")
    private Long idrole=3l;
    //пароль, но мы его не сохраняем, а хэшируем
    @Transient
    private String password;
}
