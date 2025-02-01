package com.creditas.core.strategy;

import com.creditas.core.enums.FeeType;
import org.springframework.stereotype.Component;

import java.time.temporal.ValueRange;

@Component
public class FixedFeeStrategy implements FeeStrategy {

    private final ValueRange FIRST_RANGE = ValueRange.of(0L, 25L);
    private final ValueRange SECOND_RANGE = ValueRange.of(26L, 40L);
    private final ValueRange THIRD_RANGE = ValueRange.of(41L, 60L);

    @Override
    public Double calculateFee(Integer age) {

        if (FIRST_RANGE.isValidIntValue(age))
            return 5.0;
        else if (SECOND_RANGE.isValidIntValue(age))
            return 3.0;
        else if (THIRD_RANGE.isValidIntValue(age))
            return 2.0;
        else
            return 4.0;
    }

    @Override
    public FeeType getFeeType() {
        return FeeType.FIXED;
    }
}
