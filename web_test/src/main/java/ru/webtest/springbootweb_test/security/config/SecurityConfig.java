package ru.webtest.springbootweb_test.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.webtest.springbootweb_test.entitys.Role;
import ru.webtest.springbootweb_test.security.details.UserDetailsServiceImpl;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin").hasAnyAuthority(Role.ADMIN.name())
                .antMatchers("/editor").hasAnyAuthority(Role.ADMIN.name())
                .antMatchers("/editor").hasAnyAuthority(Role.EDITOR.name())
                .antMatchers("/users").authenticated() //эта страница доступна только авторизированным пользователям
                .antMatchers("/lich_page").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("/newtest").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("/tests_page").authenticated()//эта страница доступна только авторизированным пользователям
                .antMatchers("/users_page").authenticated() //эта страница доступна только авторизированным пользователям
                .antMatchers("/main").permitAll()//эта страница доступна всем
                .antMatchers("/registration").permitAll() //эта страница доступна всем
                .and()
                .formLogin()
                .loginPage("/signIn") //форма для авторизации
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/lich_page") // если успешно переходим на личную страницу
                .failureUrl("/signIn") //если не получилось, возвращаемся на signIn
                .permitAll();

        }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
