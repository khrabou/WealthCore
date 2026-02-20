package com.nwm.WealthCore.infrastructure.persistence;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import com.nwm.WealthCore.infrastructure.persistence.portfolio.PortfolioRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(PortfolioRepositoryAdapter.class)
public class PortfolioRepositoryAdapterJpaTest {

    @Autowired
    PortfolioRepositoryPort repo;

    @Test
    void test_shouldSaveAndFindPortfolioSuccessfully() {
        UUID id = UUID.randomUUID();
        Portfolio p = new Portfolio(id, UUID.randomUUID(), "test", BigDecimal.ZERO, BigDecimal.ZERO);

        repo.save(p);

        Portfolio loaded = repo.findById(id).orElseThrow();
        assertEquals("test", loaded.getName());
    }
}
