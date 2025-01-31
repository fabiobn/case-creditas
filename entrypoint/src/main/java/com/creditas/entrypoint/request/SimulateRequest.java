package com.creditas.entrypoint.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
public class SimulateRequest {
    private Double valor;
    private LocalDate dataNascimento;
    private Integer prazo;
}
