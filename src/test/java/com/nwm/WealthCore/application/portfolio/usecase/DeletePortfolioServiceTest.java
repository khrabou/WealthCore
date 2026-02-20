package com.nwm.WealthCore.application.portfolio.usecase;

import com.nwm.WealthCore.application.portfolio.usecase.DeletePortfolioService;
import com.nwm.WealthCore.application.portfolio.port.out.PortfolioRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DeletePortfolioServiceTest {

    @Test
    void test_shouldDeletePortfolioSuccessfully() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        DeletePortfolioService service = new DeletePortfolioService(repo);
        UUID id = UUID.randomUUID();
        when(repo.existsById(id)).thenReturn(true);

        service.delete(id);

        verify(repo).deleteById(id);
    }

    @Test
    void test_shouldThrowExceptionWhenPortfolioNotFound() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        DeletePortfolioService service = new DeletePortfolioService(repo);

        UUID id = UUID.randomUUID();
        when(repo.existsById(id)).thenReturn(false);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.delete(id));
        assertEquals("Portfolio not found", ex.getMessage());
        verify(repo, never()).deleteById(any());
    }
}
