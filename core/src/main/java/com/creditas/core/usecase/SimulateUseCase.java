package com.creditas.core.usecase;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;

public interface SimulateUseCase {
    Simulation simulate(final SimulationInput simulationInput);
}
