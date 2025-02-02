package com.creditas.core.service;

import com.creditas.core.domain.MessageInput;

public interface MessageSenderService {
    <T> void sendMessage(MessageInput<T> messageInput);
}
