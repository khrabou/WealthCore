package com.nwm.WealthCore.application;

import com.nwm.WealthCore.application.portfolio.GetPortfolioService;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetPortfolioServiceTest {


    @Test
    void test_shouldReturnPortfolioSuccessfully() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        GetPortfolioService service = new GetPortfolioService(repo);
        UUID id = UUID.randomUUID();
        Portfolio p = new Portfolio(id, UUID.randomUUID(), "test", BigDecimal.ZERO, BigDecimal.ZERO);

        when(repo.findById(id)).thenReturn(Optional.of(p));

        Portfolio result = service.get(id);
        assertEquals(id, result.getId());
        assertEquals("test", result.getName());
    }

    @Test
    void test_shouldThrowExceptionWhenPortfolioNotFound() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        GetPortfolioService service = new GetPortfolioService(repo);
        UUID id = UUID.randomUUID();
        when(repo.findById(id)).thenReturn(Optional.empty());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.get(id));
        assertEquals("Portfolio not found", ex.getMessage());
    }
}
