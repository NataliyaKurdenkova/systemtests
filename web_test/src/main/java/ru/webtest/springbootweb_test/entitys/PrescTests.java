package ru.webtest.springbootweb_test.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "presc_tests")
public class PrescTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long iduser; // юзер, на которого ссылаемся

    // id назначенного теста
    private long idpresc;

}