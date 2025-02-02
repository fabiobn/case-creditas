package com.creditas.entrypoint.response;

import lombok.Builder;

@Builder
public class SimulateResponse {
    private String totalAmount;
    private String installmentAmount;
    private String totalFee;
}
