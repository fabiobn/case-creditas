package com.creditas.core.strategy;

import com.creditas.core.enums.FeeType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FeeStrategyFactory {

    private final Map<FeeType, FeeStrategy> strategiesMap = new HashMap<>();

    public FeeStrategyFactory(final Set<FeeStrategy> feeStrategies) {

        strategiesMap.putAll(
                feeStrategies.stream()
                        .collect(Collectors.toMap(FeeStrategy::getFeeType, feeStrategy -> feeStrategy))
        );
    }

    /**
     * Encontrar a strategy de acordo com o tipo passado por parâmetro.
     * @param feeType
     * @return
     * @throws Exception
     */
    public FeeStrategy find(FeeType feeType) throws Exception {

        final FeeStrategy feeStrategy = strategiesMap.get(feeType);

        if (Objects.isNull(feeStrategy)) {
            throw new Exception("Strategy Fee Implementation not found");
        }
        return feeStrategy;
    }
}
