package ru.webtest.springbootweb_test.entitys;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtest;
    //название теста
    private String name;
    //проходной балл
    private int passball;
    //общее количество вопросов в базе
    private int totalque;
    //количество вопросов. которые будут выбраны для прохождения теста
    private int needque;
    //время на тест
    private int time;

}


