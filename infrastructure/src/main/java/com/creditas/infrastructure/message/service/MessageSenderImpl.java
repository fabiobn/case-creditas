package com.creditas.infrastructure.message.service;

import com.creditas.core.domain.MessageInput;
import com.creditas.core.domain.SimulationInput;
import com.creditas.core.service.MessageSenderService;
import com.creditas.infrastructure.message.domain.MessageSimulation;
import com.creditas.infrastructure.message.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSenderService {

    private KafkaTemplate<String, MessageSimulation> kafkaTemplate;
    @Value("${message.topic.simulation}")
    private String topic;

    @Override
    public <T> void sendMessage(MessageInput<T> messageInput) {
        final MessageSimulation messageSimulation = MessageMapper
                .from((SimulationInput) messageInput.getMessage());
        kafkaTemplate.send(topic, messageSimulation);
    }
}
