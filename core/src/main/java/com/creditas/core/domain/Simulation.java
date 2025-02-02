package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Simulation {
    private Double totalAmount;
    private Double installmentAmount;
    private Double totalFee;
}
