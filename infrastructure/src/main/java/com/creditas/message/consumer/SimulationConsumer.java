package com.creditas.message.consumer;

import com.creditas.message.domain.MessageSimulation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimulationConsumer {

    @KafkaListener(topics = "${message.topic.simulation}")
    public void simulationListen(final ConsumerRecord<String, MessageSimulation> consumerRecord) {
    }
}
