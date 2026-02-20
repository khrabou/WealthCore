package com.nwm.WealthCore.application.portfolio.usecase;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.application.portfolio.port.in.UpdatePortfolioUseCase;
import com.nwm.WealthCore.application.portfolio.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdatePortfolioService implements UpdatePortfolioUseCase {
    private final PortfolioRepositoryPort repo;

    public UpdatePortfolioService(PortfolioRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public void rename(UUID id, String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        Portfolio portfolio = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));
        repo.save(portfolio.rename(name));
    }
}
