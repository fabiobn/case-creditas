package com.creditas.core.service;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private FeeService feeService;

    /**
     * Realizar uma simulação de empréstimo, a partir de parâmetros de entrada.
     * @param simulationInput Entrada para simulação empréstimo.
     * @return Resultado da simulação.
     * @throws Exception
     */
    public Simulation simulate(final SimulationInput simulationInput) throws Exception {

        // Juros mensais
        final Double monthFee = feeService.getMonthFee(simulationInput.getFeeType(), simulationInput.getAge());

        // Fórmula para cálculo da simulação de empréstimo
        final Double numerator = simulationInput.getAmount() * monthFee;
        final Double denominator = 1 - (1 / Math.pow(simulationInput.getTerm(), 1 + monthFee));
        final Double installmentAmount = numerator / denominator;

        // Total a ser pago e total de juros
        final Double totalAmount = installmentAmount * simulationInput.getTerm();
        final Double totalFee = monthFee * simulationInput.getTerm();

        return Simulation.builder()
                .installmentAmount(installmentAmount)
                .totalFee(totalFee)
                .totalAmount(totalAmount)
                .build();
    }
}
