package com.creditas.core.service;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationService {

    private FeeService feeService;

    public Simulation simulate(final SimulationInput simulationInput) {
        return null;
    }

    public List<Simulation> multipleSimulate(final List<SimulationInput> simulationInputList) {
        return null;
    }
}
