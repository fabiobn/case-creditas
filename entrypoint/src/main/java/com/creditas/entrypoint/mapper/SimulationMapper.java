package com.creditas.entrypoint.mapper;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.entrypoint.request.SimulateRequest;
import com.creditas.entrypoint.response.SimulateResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SimulationMapper {

    public static SimulationInput from(final SimulateRequest simulateRequest) {
        return SimulationInput.builder()
                .valor(simulateRequest.getValor())
                .dataNascimento(simulateRequest.getDataNascimento())
                .prazo(simulateRequest.getPrazo())
                .build();
    }

    public static SimulateResponse from(final Simulation simulation) {
        return SimulateResponse.builder()
                .valorTotal(simulation.getValorTotal().toString())
                .valorParcela(simulation.getValorParcela().toString())
                .taxaJuros(simulation.getTaxaJuros().toString())
                .build();
    }
}
