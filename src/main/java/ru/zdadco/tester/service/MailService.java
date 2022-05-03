package ru.zdadco.tester.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;

    public void sendResult(String email, File file) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("");
        helper.setTo(email);
        helper.setSubject("Результат тестирования");
        helper.setText("Благодарим за прохождение теста.\nРезультаты в прикрепленном е письму файле.");
        helper.addAttachment("Invoice", file);

        emailSender.send(message);
    }

}
