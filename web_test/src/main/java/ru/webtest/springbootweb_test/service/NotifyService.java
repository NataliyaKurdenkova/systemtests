package ru.webtest.springbootweb_test.service;

import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class NotifyService {
    public static void recoveryPassLinkCreateAndSend (String redactorLogin, String userName, String testName, String testResult) throws MessagingException {
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
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(redactorLogin));
        //Тема письма
        message.setSubject("Уведомление об успешной сдачи теста!");
        //Текст письма
        message.setText("Пользователь: " + userName + " тест " + testName + " успешно сдал. Результат: " + testResult);
        //Поехали!!!
        Transport.send(message);
    }
}