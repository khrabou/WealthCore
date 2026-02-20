package com.nwm.WealthCore.application.portfolio;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.in.portfolio.GetPortfolioUseCase;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetPortfolioService implements GetPortfolioUseCase {
    private final PortfolioRepositoryPort repo;

    public GetPortfolioService(PortfolioRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Portfolio get(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));
    }
}
