package com.creditas.infrastructure.message.consumer;

import com.creditas.core.domain.SimulationInput;
import com.creditas.core.usecase.SimulateUseCase;
import com.creditas.infrastructure.message.domain.MessageSimulation;
import com.creditas.infrastructure.message.mapper.MessageMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimulationConsumer {

    private SimulateUseCase simulateUseCase;

    @KafkaListener(topics = "${message.topic.simulation}")
    public void simulationListen(final ConsumerRecord<String, MessageSimulation> consumerRecord) {

        try {
            final MessageSimulation messageSimulation = consumerRecord.value();

            final SimulationInput simulationInput = MessageMapper.from(messageSimulation);

            simulateUseCase.simulate(simulationInput);
        } catch (Exception e) {
            // TODO: Realizar tratamento para retentativa e envio para DLT
            throw new RuntimeException(e);
        }
    }
}
