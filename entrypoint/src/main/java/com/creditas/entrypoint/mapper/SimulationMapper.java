package com.creditas.entrypoint.mapper;

import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.entrypoint.request.MultipleSimulateRequest;
import com.creditas.entrypoint.request.SimulateRequest;
import com.creditas.entrypoint.response.SimulateResponse;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class SimulationMapper {

    public static SimulationInput from(final SimulateRequest simulateRequest) {

        if (Objects.isNull(simulateRequest))
            return SimulationInput.builder().build();

        return SimulationInput.builder()
                .amount(simulateRequest.getAmount())
                .birthDate(simulateRequest.getBirthDate())
                .term(simulateRequest.getTerm())
                .feeType(simulateRequest.getFeeType())
                .build();
    }

    public static List<SimulationInput> from(final MultipleSimulateRequest multipleSimulateRequest) {

        if (Objects.isNull(multipleSimulateRequest)
                || CollectionUtils.isEmpty(multipleSimulateRequest.getSimulations()))
            return List.of();

        return multipleSimulateRequest.getSimulations().stream()
                .map(SimulationMapper::from).collect(Collectors.toList());
    }

    public static SimulateResponse from(final Simulation simulation) {

        if (Objects.isNull(simulation))
            return SimulateResponse.builder().build();

        return SimulateResponse.builder()
                .totalAmount(String.format("R$ %.2f", simulation.getTotalAmount()))
                .installmentAmount(String.format("R$ %.2f", simulation.getInstallmentAmount()))
                .totalFee(String.format("%.2f %%", simulation.getTotalFee()))
                .build();
    }

    public static List<SimulateResponse> from(final List<Simulation> simulationList) {

        if (CollectionUtils.isEmpty(simulationList))
            return List.of();

        return simulationList.stream()
                .map(SimulationMapper::from).collect(Collectors.toList());
    }
}
