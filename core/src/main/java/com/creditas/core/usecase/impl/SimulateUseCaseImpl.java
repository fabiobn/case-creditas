package com.creditas.core.usecase.impl;

import com.creditas.core.domain.EmailInput;
import com.creditas.core.domain.MessageInput;
import com.creditas.core.domain.Simulation;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.service.EmailService;
import com.creditas.core.service.MessageSenderService;
import com.creditas.core.service.SimulationService;
import com.creditas.core.usecase.SimulateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulateUseCaseImpl implements SimulateUseCase {

    private SimulationService simulationService;
    private EmailService emailService;
    private MessageSenderService messageSenderService;

    /**
     * Realizar simulação de empréstimo e envia resultado por e-mail.
     * @param simulationInput Informações de entrada para a simulação.
     * @return Retorna objeto com resulado da simulação.
     * @throws Exception
     */
    @Override
    public Simulation simulate(final SimulationInput simulationInput) throws Exception {

        try {
            // Realiza a simulação de empréstimo
            final Simulation simulation = simulationService.simulate(simulationInput);

            // Envia e-mail com a informação da simulação
            final String message = String
                    .format("Informação de simulação: Valor total: R$ %f, Juros total: %f, Valor parcela: R$ %f",
                            simulation.getTotalAmount(), simulation.getTotalFee(), simulation.getInstallmentAmount());
            final EmailInput emailInput = EmailInput.builder()
                    .from("creditas.simulacao@creditas.com")
                    .to("user.creditas@creditas.com")
                    .subject("Simulação")
                    .message(message)
                    .build();

            emailService.send(emailInput);

            return simulation;
        } catch (Exception ex) {
            //TODO: Realizar organização de mensagens de erro para ser tratada pelo controller advice
            throw new Exception("Erro ao realizar a simulação de empréstimo.", ex);
        }
    }

    @Override
    public void multipleSimulate(final List<SimulationInput> simulationInputList) {

        // Para cada entrada de simulação
        simulationInputList.forEach(simulationInput -> {
            final MessageInput<SimulationInput> messageInput = MessageInput.<SimulationInput>builder()
                    .message(simulationInput)
                    .build();

            // Enviar para processamento assíncrono
            messageSenderService.sendMessage(messageInput);
        });
    }
}
