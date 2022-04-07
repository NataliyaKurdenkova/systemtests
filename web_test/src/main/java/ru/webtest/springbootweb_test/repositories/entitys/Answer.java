package ru.webtest.springbootweb_test.repositories.entitys;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idanswer;
    //сам ответ
    private String name;

    //правильный или нет
    private int correct;

    //к какому вопросу принадлежит
    private int parent;


}
