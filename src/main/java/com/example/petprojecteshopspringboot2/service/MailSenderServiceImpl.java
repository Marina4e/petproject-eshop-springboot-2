package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {

    private final JavaMailSender mailSender;
    @Value("${server.port}")
    private int port;
    @Value("${server.hostname}")
    private String hostname;

    public MailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendActivateCode(User user) {
        String subject = "Please, activate your account";
        String content = "To activate your account, go to the link: \n"
                + "http://" + hostname + ":" + port + "/users/activate/" +
                user.getActivateCode();

        sendMail(user.getEmail(), subject, content);
    }

    private void sendMail(String email, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test.mail.24092024@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
