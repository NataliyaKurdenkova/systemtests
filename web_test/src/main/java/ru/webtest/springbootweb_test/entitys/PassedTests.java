package ru.webtest.springbootweb_test.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "passed_tests")
public class PassedTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long iduser; // юзер, на которого ссылаемся

    // id пройденного теста
    private long idpassed;
}