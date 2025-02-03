package com.creditas.core.service;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.enums.FeeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimulationServiceTest {

    @Mock
    private FeeService feeService;

    @InjectMocks
    private SimulationService simulationService;

    @Test
    @DisplayName("Deve retornar simulação com sucesso")
    void shouldReturnSimulationSuccefully() throws Exception {

        final SimulationInput simulationInputMock = SimulationInput.builder()
                .feeType(FeeType.FIXED)
                .term(10)
                .birthDate(LocalDate.of(2000, 10, 20))
                .amount(10000.00)
                .build();

        when(feeService.getMonthFee(any(FeeType.class), any(Integer.class))).thenReturn(3.0);

        Simulation simulation = simulationService.simulate(simulationInputMock);

        assertNotNull(simulation);
        assertEquals(30.0, simulation.getTotalFee());
    }
}
