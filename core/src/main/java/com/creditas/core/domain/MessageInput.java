package com.creditas.core.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageInput<T> {

    private T message;
}
