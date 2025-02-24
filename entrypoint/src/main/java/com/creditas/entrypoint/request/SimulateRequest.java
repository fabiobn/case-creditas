package com.creditas.entrypoint.request;

import com.creditas.core.enums.FeeType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SimulateRequest {
    private Double amount;
    private LocalDate birthDate;
    private Integer term;
    private FeeType feeType;
}
