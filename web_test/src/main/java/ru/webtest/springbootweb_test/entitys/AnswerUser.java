package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "answers_user")
public class AnswerUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //номер вопроса к которому принадлежит ответ
    private long idquestion;

    //номер выбранного ответа
    private long idanswer;

    //правильный или нет
    private int correct;




}