package ru.webtest.springbootweb_test.service;


import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SignInService {



    public static void recoveryPassLinkCreateAndSend (String login, Long idUser) throws MessagingException {

        //Объект properties хранит параметры соединения.
        //Для каждого почтового сервера они разные.
        //Если не знаете нужные - обратитесь к администратору почтового сервера.
        //Ну или гуглите;=)
        //Конкретно для Yandex параметры соединения можно подсмотреть тут:
        //https://yandex.ru/support/mail/mail-clients.html (раздел "Исходящая почта")
        Properties properties = new Properties();
        //Хост или IP-адрес почтового сервера
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        //Требуется ли аутентификация для отправки сообщения
        properties.put("mail.smtp.auth", "true");
        //Порт для установки соединения
        properties.put("mail.smtp.socketFactory.port", "465");
        //Фабрика сокетов, так как при отправке сообщения Yandex требует SSL-соединения
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //Создаем соединение для отправки почтового сообщения
        Session session = Session.getDefaultInstance(properties,
                //Аутентификатор - объект, который передает логин и пароль

                /**
                 * Сделано для почты яндекса
                 */
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("sistema.testirovania@yandex.ru", "xbofnkmdvgctthsz");
                    }
                });

        //Создаем новое почтовое сообщение
        Message message = new MimeMessage(session);
        //От кого
        message.setFrom(new InternetAddress("sistema.testirovania@yandex.ru"));
        //Кому
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(login));
        //Тема письма
        message.setSubject("Восстановление пароля!");
        //Текст письма
        message.setText("Поступил запрос на восстановление пароля. Для этого перейдите по ссылке: http://localhost:8189/updatePass?" + idUser);
        //Поехали!!!
        Transport.send(message);
    }

}





