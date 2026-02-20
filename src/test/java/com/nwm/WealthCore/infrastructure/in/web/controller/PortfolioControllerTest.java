package com.nwm.WealthCore.infrastructure.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwm.WealthCore.config.TestSecurityConfig;
import com.nwm.WealthCore.infrastructure.out.persistence.portfolio.PortfolioEntity;
import com.nwm.WealthCore.infrastructure.out.persistence.portfolio.PortfolioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Import(TestSecurityConfig.class)
public class PortfolioControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    PortfolioRepository repo;
    @Autowired
    ObjectMapper om;

    @Test
    void test_shouldReturnNotFoundWhenPortfolioDoesNotExist() throws Exception {
        mvc.perform(get("/api/portfolios/" + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_shouldRenameDeleteAndCalculatePerformanceSuccessfully() throws Exception {
        UUID id = UUID.randomUUID();
        UUID clientId = UUID.randomUUID();

        repo.saveAndFlush(new PortfolioEntity(id, clientId, "Main",
                new BigDecimal("1000"), new BigDecimal("1100")));
        mvc.perform(get("/api/portfolios/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Main"));

        mvc.perform(put("/api/portfolios/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Renamed\"}"))
                .andExpect(status().isNoContent());

        mvc.perform(get("/api/portfolios/" + id + "/performance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.benefit").value(100))
                .andExpect(jsonPath("$.performancePct").value(10));
    }
}
