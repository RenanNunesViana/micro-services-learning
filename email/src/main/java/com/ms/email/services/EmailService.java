package com.ms.email.services;

import com.ms.email.dtos.EmailRecordDto;

public interface EmailService {
    EmailRecordDto sendEmail(EmailRecordDto email);
}
