package com.creditas.core.domain;

import com.creditas.core.enums.FeeType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Builder
@Data
public class SimulationInput {
    private Double amount;
    private LocalDate birthDate;
    private Integer term;
    private FeeType feeType;

    /**
     * Obter idade a partir da data de nascimento.
     * @return Idade
     */
    public Integer getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
