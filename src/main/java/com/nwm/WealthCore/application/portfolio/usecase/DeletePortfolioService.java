package com.nwm.WealthCore.application.portfolio.usecase;

import com.nwm.WealthCore.application.portfolio.port.in.DeletePortfolioUseCase;
import com.nwm.WealthCore.application.portfolio.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletePortfolioService implements DeletePortfolioUseCase {
    private final PortfolioRepositoryPort repo;

    public DeletePortfolioService(PortfolioRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void delete(UUID id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Portfolio not found");
        repo.deleteById(id);
    }
}
