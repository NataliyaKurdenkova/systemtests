package ru.webtest.springbootweb_test.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "presc_passed_tests")
public class PrescPassedTests {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long iduser; // юзер, на которого ссылаемся

    // id назначенного теста
    private long idpresc;

    // id пройденного теста
    private long idpassed;
}
