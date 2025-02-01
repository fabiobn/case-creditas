package com.creditas.core.strategy;

import com.creditas.core.enums.FeeType;

public interface FeeStrategy {

    Double calculateFee(Integer age);

    FeeType getFeeType();
}
