package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Simulation {
    private Double valorTotal;
    private Double valorParcela;
    private Double taxaJuros;
}
