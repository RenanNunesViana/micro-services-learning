package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.services.EmailService;
import com.ms.email.services.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailServiceImpl emailServiceImpl) {
        this.emailService = emailServiceImpl;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto email){
        emailService.sendEmail(email);
        System.out.println(email.emailTo());
    }
}
