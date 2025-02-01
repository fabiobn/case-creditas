package com.creditas.core.strategy;

import com.creditas.core.enums.FeeType;
import org.springframework.stereotype.Component;

@Component
public class VariableFeeStrategy implements FeeStrategy {

    @Override
    public Double calculateFee(Integer age) {
        return 0.0;
    }

    @Override
    public FeeType getFeeType() {
        return FeeType.VARIABLE;
    }
}
