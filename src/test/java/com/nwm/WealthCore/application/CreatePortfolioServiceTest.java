package com.nwm.WealthCore.application;

import com.nwm.WealthCore.application.portfolio.CreatePortfolioService;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreatePortfolioServiceTest {


    @Test
    void test_shouldCreateSuccessfull() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        CreatePortfolioService service = new CreatePortfolioService(repo);

        UUID clientId = UUID.randomUUID();
        when(repo.save(any(Portfolio.class))).thenAnswer(p -> p.getArgument(0));

        UUID createdId = service.create(clientId, "testName");

        assertNotNull(createdId);
        verify(repo, times(1)).save(any(Portfolio.class));
    }

    @Test
    void test_shouldCreateFailure() {
        PortfolioRepositoryPort repo = mock(PortfolioRepositoryPort.class);
        CreatePortfolioService service = new CreatePortfolioService(repo);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.create(UUID.randomUUID(), "   "));
        assertEquals("name required", ex.getMessage());
        verify(repo, never()).save(any());
    }
}
