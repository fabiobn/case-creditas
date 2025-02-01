package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SimulationInput {
    private Double amount;
    private LocalDate birthDate;
    private Integer term;
}
