package com.nwm.WealthCore.application.portfolio;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.in.portfolio.CreatePortfolioUseCase;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreatePortfolioService implements CreatePortfolioUseCase {
    private final PortfolioRepositoryPort repo;

    public CreatePortfolioService(PortfolioRepositoryPort repo) {
        this.repo = repo;
    }


    @Override
    @Transactional
    public UUID create(UUID clientId, String name) {
        if (clientId == null) throw new IllegalArgumentException("clientId required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");

        Portfolio portfolio = repo.save(Portfolio.create(clientId, name.trim()));
        return portfolio.getId();
    }
}
