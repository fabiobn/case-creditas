package com.creditas.message.mapper;

import com.creditas.core.domain.SimulationInput;
import com.creditas.message.domain.MessageSimulation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageMapper {

    public static MessageSimulation from(final SimulationInput simulationInput) {
        return MessageSimulation.builder()
                .term(simulationInput.getTerm())
                .amount(simulationInput.getAmount())
                .birthDate(simulationInput.getBirthDate())
                .feeType(simulationInput.getFeeType())
                .build();
    }
}
