package com.nwm.WealthCore.application.portfolio.usecase;

import com.nwm.WealthCore.application.portfolio.usecase.GetPortfolioPerformanceService;
import com.nwm.WealthCore.domain.model.Performance;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.application.portfolio.port.out.PortfolioRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GetPortfolioPerformanceServiceTest {
    @Test
    void test_shouldCalculatePerformanceSuccessfully() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        GetPortfolioPerformanceService service = new GetPortfolioPerformanceService(repo);

        UUID id = UUID.randomUUID();
        Portfolio p = new Portfolio(
                id, UUID.randomUUID(), "test",
                new BigDecimal("1000"), new BigDecimal("1100")
        );
        when(repo.findById(id)).thenReturn(Optional.of(p));

        Performance perf = service.get(id);

        assertEquals(new BigDecimal("1000"), perf.investedAmount());
        assertEquals(new BigDecimal("1100"), perf.currentValue());
        assertEquals(new BigDecimal("100"), perf.benefit());
        assertTrue(perf.performancePct().compareTo(new BigDecimal("10")) == 0);
    }

    @Test
    void test_shouldReturnZeroPercentageWhenInvestedAmountIsZero() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        GetPortfolioPerformanceService service = new GetPortfolioPerformanceService(repo);

        UUID id = UUID.randomUUID();
        Portfolio p = new Portfolio(
                id, UUID.randomUUID(), "test",
                BigDecimal.ZERO, new BigDecimal("100")
        );

        when(repo.findById(id)).thenReturn(Optional.of(p));

        Performance perf = service.get(id);

        assertEquals(new BigDecimal("100"), perf.benefit());
        assertEquals(BigDecimal.ZERO, perf.performancePct());
    }

}
