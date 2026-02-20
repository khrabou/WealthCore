package com.nwm.WealthCore.application;

import com.nwm.WealthCore.application.portfolio.UpdatePortfolioService;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UpdatePortfolioServiceTest {

    @Test
    void test_shouldRenamePortfolioSuccessfully() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        UpdatePortfolioService service = new UpdatePortfolioService(repo);

        UUID id = UUID.randomUUID();
        Portfolio existing = new Portfolio(id, UUID.randomUUID(), "OldName", BigDecimal.ZERO, BigDecimal.ZERO);

        when(repo.findById(id)).thenReturn(Optional.of(existing));
        when(repo.save(any(Portfolio.class))).thenAnswer(p -> p.getArgument(0));

        service.rename(id, "New");

        verify(repo).save(argThat(p -> p.getName().equals("New")));
    }

    @Test
    void test_shouldThrowExceptionWhenPortfolioNotFound() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        UpdatePortfolioService service = new UpdatePortfolioService(repo);

        UUID id = UUID.randomUUID();
        when(repo.findById(id)).thenReturn(Optional.empty());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.rename(id, "New"));
        assertEquals("Portfolio not found", ex.getMessage());
    }

}
