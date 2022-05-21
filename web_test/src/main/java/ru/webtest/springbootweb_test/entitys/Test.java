package ru.webtest.springbootweb_test.entitys;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.webtest.springbootweb_test.repositories.AnswerRepository;
import ru.webtest.springbootweb_test.repositories.QuestionRepository;
import ru.webtest.springbootweb_test.repositories.TestsRepository;

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
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "parent")
    private Collection<Question> questions;


    public Test(Long idtest, String name, int passball, int totalque, int needque, int time) {
        this.idtest = idtest;
        this.name = name;
        this.passball = passball;
        this.totalque = totalque;
        this.needque = needque;
        this.time = time;
    }
}


