package com.creditas.infrastructure.message.config;

import com.creditas.infrastructure.message.domain.MessageSimulation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, MessageSimulation> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, MessageSimulation> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
