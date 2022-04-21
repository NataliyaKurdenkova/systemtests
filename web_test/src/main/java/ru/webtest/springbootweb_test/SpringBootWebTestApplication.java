package ru.webtest.springbootweb_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootWebTestApplication {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebTestApplication.class, args);
//        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
//        System.out.println(encoder.encode("pass"));
        SpringApplication.run(SpringBootWebTestApplication.class, args);
    }

}
