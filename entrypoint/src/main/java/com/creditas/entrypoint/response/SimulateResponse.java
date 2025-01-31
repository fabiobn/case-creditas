package com.creditas.entrypoint.response;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class SimulateResponse {
    private String valorTotal;
    private String valorParcela;
    private String taxaJuros;
}
