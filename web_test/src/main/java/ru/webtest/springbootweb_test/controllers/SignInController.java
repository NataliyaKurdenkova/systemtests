package ru.webtest.springbootweb_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.webtest.springbootweb_test.services.signInService;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Controller
public class SignInController {

    private static Statement stmt;
    private static Connection connection;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signIn")
    public String getSignIn() {
        return "signIn";
    }

    @PostMapping("/recovery")
    public String recoveryPass(){
        return "recoveryPassReset_page";
    }

    @PostMapping("/afterRecovery")
    public String afterRecoveryPass(String login){

        try {
            // соединяемся с базой данных
            connect();

            try (ResultSet resultSet = stmt.executeQuery("Select * FROM dbtests.account")) {
                while (resultSet.next()) {
                    String sqlLogin = resultSet.getString("login");

                    if (login.equals(sqlLogin)) {
                        // метод, генерирующий ссылку для создания нового пароля и отправляющий ее пользователю
                        signInService.recoveryPassLinkCreateAndSend(login, resultSet.getLong("iduser"));
                        return "recoveryPassAfterReset_page";
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return "noLogin_page";
    }

    @GetMapping("/updatePass")
    public String updatePass(HttpServletRequest idUser) {
        idUser.setAttribute("idUser", idUser.getQueryString());
       return "passUpdate_page";
    }

    @PostMapping("/enterNewPass")

    public String saveNewPass(HttpServletRequest idUser, String pass1, String pass2, HttpServletRequest flag){

        if (pass1.equals(pass2)) {

            try {
                connect();
                String str = "'" + passwordEncoder.encode(pass1) + "'";
                long id = Long.valueOf(idUser.getQueryString());
                stmt.executeUpdate("UPDATE dbtests.account SET hash_password = " + str + " WHERE iduser = " + id);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
            return "signIn";

            /** ДЛЯ ФРОНТЕНДЕРА
             * На странице, отобразить, что пароль успешно изменен.
             * В качестве маркера для этого на фронтенд передается атрибут flag со строковым значением true
             * Его нужно обработать на фронтенде и отобразить надпись, что пароль успешно изменен.
             */


        } else {

            idUser.setAttribute("idUser", idUser.getQueryString());

            flag.setAttribute("false", "false");

            return "passUpdate_page";

            /** ДЛЯ ФРОНТЕНДЕРА
             * На странице, отобразить, что новые пароли не сопадают, давай вводи заново.
             * В качестве маркера для этого на фронтенд передается атрибут flag со строковым значением false
             * Его нужно обработать на фронтенде и отобразить надпись, что пароли не совпадают.
             */
        }
    }

    // метод, открывающий соединение с базой данных
    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtests", "root", "Gkxpupva123");
        stmt = connection.createStatement();
    }

    // метод, закрывающий соединение с базой данных
    private void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
