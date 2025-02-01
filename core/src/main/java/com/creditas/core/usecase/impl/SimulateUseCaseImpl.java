package com.creditas.core.usecase.impl;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.service.SimulationService;
import com.creditas.core.usecase.SimulateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulateUseCaseImpl implements SimulateUseCase {

    private SimulationService simulationService;

    @Override
    public Simulation simulate(final SimulationInput simulationInput) {
        return null;
    }

    @Override
    public List<Simulation> multipleSimulate(final List<SimulationInput> simulationInputList) {
        return null;
    }
}
