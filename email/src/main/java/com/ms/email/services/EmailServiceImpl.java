package com.ms.email.services;

import com.ms.email.dtos.EmailRecordDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailServiceImpl implements EmailService{
    final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailRecordDto sendEmail(EmailRecordDto email){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.emailTo());
            message.setFrom(emailFrom);
            message.setSubject(email.subject());
            message.setText(email.text());
            emailSender.send(message);
        }catch (MailException e){
            System.out.println("something gone wrong");
        }
        finally {
            return email;
        }
    }
}
