package com.creditas.core.usecase;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;

import java.util.List;

public interface SimulateUseCase {
    Simulation simulate(final SimulationInput simulationInput) throws Exception;
    void multipleSimulate(final List<SimulationInput> simulationInputList);
}
