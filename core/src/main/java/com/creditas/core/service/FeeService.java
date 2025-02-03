package com.creditas.core.service;

import com.creditas.core.enums.FeeType;
import com.creditas.core.strategy.FeeStrategy;
import com.creditas.core.strategy.FeeStrategyFactory;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

    private FeeStrategyFactory feeStrategyFactory;

    /**
     * Obter a taxa de juros anual de acordo com a idade do cliente.
     * @param age Idade do cliente para o cálculo.
     * @return Retorna a taxa de juros anual.
     */
    public Double getAnnualFee(FeeType feeType, Integer age) throws Exception {

        final FeeStrategy feeStrategy = feeStrategyFactory.find(feeType);

        return feeStrategy.calculateFee(age);
    }

    /**
     * Obter a taxa de juros mensal de acordo com a idade do cliente.
     * @param age Idade do cliente para o cálculo.
     * @return Retorna a taxa de juros mensal.
     */
    public Double getMonthFee(FeeType feeType, Integer age) throws Exception {

        final Double anualFee = getAnnualFee(feeType, age);

        return anualFee/12;
    }
}
