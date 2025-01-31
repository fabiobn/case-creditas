package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SimulationInput {
    private Double valor;
    private LocalDate dataNascimento;
    private Integer prazo;
}
