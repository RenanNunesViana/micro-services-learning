package com.ms.user.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EmailDto {
    UUID userId;
    String emailTo;
    String subject;
    String text;
}
