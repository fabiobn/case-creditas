package com.creditas.entrypoint.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class MultipleSimulateRequest {
    private List<SimulateRequest> simulations;
}
