package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "parent")
    private int parent;


    //количество ответов по номеру вопроса
    private int countAnsw(Long id) {
        int count = 0;
        System.out.println(count);
        return count;
    }

    //отпределение верного ответа
    public String correctAnswer(long id) {
        return null;
    }

    //сколько баллов состоявляет ответ на 1 вопрос
    //общее количество балллов за ответ на этот вопрос/на количество парвильных ответов
    public int getBalls() {
        int balls = 0;
        return balls;
    }


}
