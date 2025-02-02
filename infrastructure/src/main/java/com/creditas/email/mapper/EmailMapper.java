package com.creditas.email.mapper;

import com.creditas.core.domain.EmailInput;
import com.creditas.email.domain.Email;
import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class EmailMapper {

    public static Email from(final EmailInput emailInput) {

        if (Objects.isNull(emailInput))
            return Email.builder().build();

        return Email.builder()
                .from(emailInput.getFrom())
                .to(emailInput.getTo())
                .subject(emailInput.getSubject())
                .message(emailInput.getMessage())
                .build();
    }
}
