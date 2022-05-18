package ru.webtest.springbootweb_test.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttemptView {
        private Long id;
        //имя пользователя
        private String username;
        //имя теста
        private String testname;
        //количество попыток
        private int attempt;
        //время и дата когда проходил тест
        private String currentDataTime;
        //количество набранных баллов
        private double balls;
        //время прохождения теста (последняя попытка)
        private String timeTest;

    }


