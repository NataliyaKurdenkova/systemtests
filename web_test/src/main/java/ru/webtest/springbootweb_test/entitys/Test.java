package ru.webtest.springbootweb_test.entitys;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tests")
public class Test {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long idtest;

        private String name;
        private int passball;
        private int totalque;
        private int needque;
        private int time;

    }


