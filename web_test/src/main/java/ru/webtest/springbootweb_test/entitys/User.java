package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long iduser;
    private String login;
    private String password;
    private String name;
    private Long idrole;

}
