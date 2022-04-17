package ru.webtest.springbootweb_test.entitys;

import org.springframework.data.annotation.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TestChoice {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "iduser")
    User user;

    @ManyToOne
    @JoinColumn(name = "idtest")
    Test test;

}
