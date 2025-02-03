package com.creditas.infrastructure.message.domain;

import com.creditas.core.enums.FeeType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MessageSimulation {
    private Double amount;
    private LocalDate birthDate;
    private Integer term;
    private FeeType feeType;
}
