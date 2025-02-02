package com.creditas.message.enums;

import lombok.Getter;

@Getter
public enum TopicEnum {
    SIMULATION_TOPIC("simulation");

    private final String topicName;

    TopicEnum(final String topicName) {
        this.topicName = topicName;
    }
}
