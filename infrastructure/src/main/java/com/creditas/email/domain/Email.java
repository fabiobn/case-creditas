package com.creditas.email.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Email {
    private String from;
    private String to;
    private String subject;
    private String message;
}
