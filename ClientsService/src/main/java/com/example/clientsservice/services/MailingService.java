package com.example.clientsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
    public static final String subject = "Account balance";
    public static final String text = "yours account balance is 0";
    @Autowired
    private JavaMailSender javaMailSender;


    public void sendMail(final String toAddress, String surname) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(surname + " " + text);
        javaMailSender.send(message);
    }
}
