package ru.webtest.springbootweb_test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/answer/**").authenticated() //эта страница доступна только авторизированным пользователям
               .antMatchers("/users/**").access("hasRole('ADMIN')") //эта страница доступна только admin
                .antMatchers("/statistic").access("hasRole('ADMIN')") //эта страница доступна только admin
                .antMatchers("/lich_page/**").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("//passedtests/**").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("/newtest").access("hasAnyRole('ADMIN','EDITOR')")//эта страница доступна только авторизированным пользователям
                .antMatchers("/tests/**").access("hasAnyRole('ADMIN','EDITOR')")
                // .antMatchers("/tests/**").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("/main").permitAll()//эта страница доступна всем
                .antMatchers("/").permitAll()//эта страница доступна всем
                //.antMatchers("/registration").permitAll()//эта страница доступна всем
                .antMatchers("/registration").not().fullyAuthenticated() //эта страница доступна только не для зарегистрированных пользователей
                // .antMatchers("/passing_test/**").authenticated()//эта страница доступна только авторизированным пользователям
                //Все остальные страницы требуют аутентификации
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn") //форма для авторизации
                .usernameParameter("login")
                .passwordParameter("password")
                // .defaultSuccessUrl("/lich_page") // если успешно переходим на личную страниц
                .defaultSuccessUrl("/default")// если успешно переходим на личную страниц
                // .failureUrl("/signIn") //если не получилось, возвращаемся на signIn
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);


    }


}
