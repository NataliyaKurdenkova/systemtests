package ru.webtest.springbootweb_test.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerUser {
    //номер вопроса к которому принадлежит ответ
    private String questionName;

    //номер выбранного ответа
    private List<String> answerName=new ArrayList<>();

     //правильный или нет
    private int correct;

    public void setAnswerName(String name) {
        answerName.add(name);
    }
}





