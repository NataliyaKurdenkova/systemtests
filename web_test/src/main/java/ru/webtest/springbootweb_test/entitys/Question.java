package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idque;
    //вопрос
    @Column(name = "question")
    private String question;




    //к какому тесту принадлежит
    private long parent;

    //ответы
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "parent")
    private List<Answer> answers;







  /*  //сколько баллов состоявляет ответ на 1 вопрос
    //общее количество балллов за ответ на этот вопрос/на количество парвильных ответов
    public int getBalls() {
        int balls = 0;
        return balls;
    }
*/

}