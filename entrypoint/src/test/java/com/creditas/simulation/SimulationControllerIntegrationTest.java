package com.creditas.simulation;

import com.creditas.core.enums.FeeType;
import com.creditas.entrypoint.controller.SimulationController;
import com.creditas.entrypoint.request.SimulateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SimulationApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class SimulationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimulationController simulationController;

    @Test
    @DisplayName("Deve carregar contexto com controller")
    public void contextLoads() throws Exception {
        assertThat(simulationController).isNotNull();
    }


    @Test
    public void givenSimulateInput_whenSimulate_thenStatus200() throws Exception {

        final SimulateRequest simulateRequestMock = SimulateRequest.builder()
                .amount(1000.00)
                .term(10)
                .birthDate(LocalDate.of(2000, 10, 20))
                .feeType(FeeType.FIXED)
                .build();

        mockMvc.perform(post("/simulation")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(simulateRequestMock)))
                .andExpect(status().isOk());
    }
}
