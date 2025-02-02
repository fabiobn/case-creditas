package com.creditas.core.service;

import com.creditas.core.domain.EmailInput;

public interface EmailService {
    void send(EmailInput emailInput);
}
