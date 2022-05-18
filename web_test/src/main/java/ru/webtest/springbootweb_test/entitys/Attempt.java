package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attempts")
public class Attempt{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //номер пользователя

     private long iduser;

    //номер теста
    private long idtest;

    //количество попыток
    private int attempt;

    //время и дата когда проходил тест
    private String currentDataTime;

    //количество набранных баллов
    private double balls;

    //время прохождения теста (последняя попытка)
    private String timeTest;
/*
    //ответы
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "attempts_id")
    private Collection<AnswerUser> answerUsers;

*/



}
