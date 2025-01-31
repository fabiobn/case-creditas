package com.creditas.entrypoint.controller;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.usecase.SimulateUseCase;
import com.creditas.entrypoint.mapper.SimulationMapper;
import com.creditas.entrypoint.request.SimulateRequest;
import com.creditas.entrypoint.response.SimulateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("simulation")
public class SimulationController {

    private SimulateUseCase simulateUseCase;

    @PostMapping
    public SimulateResponse simulate(@RequestBody SimulateRequest simulateRequest) {

        SimulationInput simulationInput = SimulationMapper.from(simulateRequest);

        Simulation simulation = simulateUseCase.simulate(simulationInput);

        return SimulationMapper.from(simulation);
    }
}
