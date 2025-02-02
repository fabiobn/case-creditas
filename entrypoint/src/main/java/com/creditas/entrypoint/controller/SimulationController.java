package com.creditas.entrypoint.controller;

import com.creditas.core.domain.MessageInput;
import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.service.MessageSenderService;
import com.creditas.core.usecase.SimulateUseCase;
import com.creditas.entrypoint.mapper.SimulationMapper;
import com.creditas.entrypoint.request.MultipleSimulateRequest;
import com.creditas.entrypoint.request.SimulateRequest;
import com.creditas.entrypoint.response.ResponseApi;
import com.creditas.entrypoint.response.SimulateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("simulation")
public class SimulationController {

    private SimulateUseCase simulateUseCase;

    @PostMapping
    public ResponseEntity<ResponseApi<SimulateResponse>> simulate(
            @RequestBody SimulateRequest simulateRequest) throws Exception {

        // Mapeia para objeto de domínio
        final SimulationInput simulationInput = SimulationMapper.from(simulateRequest);

        // Processa simulação
        final Simulation simulation = simulateUseCase.simulate(simulationInput);

        // Converte para resposta do endpoint
        final SimulateResponse simulateResponse = SimulationMapper.from(simulation);

        return ResponseEntity.ok(buildResponseApi(simulateResponse));
    }

    @PostMapping
    public ResponseEntity<ResponseApi<List<SimulateResponse>>> multipleSimulate(
            @RequestBody MultipleSimulateRequest multipleSimulateRequest) {

        // Mapeia para lista de objeto de domínio
        final List<SimulationInput> multipleSimulationInput = SimulationMapper.from(multipleSimulateRequest);

        // Processa múltiplas simulações
        final List<Simulation> simulationList = simulateUseCase.multipleSimulate(multipleSimulationInput);

        // Converte para resposta do endpoint
        final List<SimulateResponse> simulateResponseList = SimulationMapper.from(simulationList);

        return ResponseEntity.ok(buildResponseApi(simulateResponseList));
    }

    /**
     * Construir resposta da API com resultado.
     * @param content Resultado a ser retornado.
     * @return Objeto de resposta da API com conteúdo de retorno.
     */
    private <T> ResponseApi<T> buildResponseApi(T content) {
        return ResponseApi.<T>builder().content(content).build();
    }
}
