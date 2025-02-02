package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailInput {
    private String from;
    private String to;
    private String subject;
    private String message;
}
