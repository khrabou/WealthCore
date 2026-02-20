package com.nwm.WealthCore.infrastructure.persistence.portfolio;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PortfolioRepositoryAdapter implements PortfolioRepositoryPort {

    private final PortfolioRepository repo;

    public PortfolioRepositoryAdapter(PortfolioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        PortfolioEntity portfolioEntity = repo.save(new PortfolioEntity(portfolio.getId(), portfolio.getClientId(), portfolio.getName(), portfolio.getInvestedAmount(), portfolio.getCurrentValue()));
        return  new Portfolio(portfolioEntity.getId(), portfolioEntity.getClientId(), portfolioEntity.getName(), portfolio.getInvestedAmount(), portfolio.getCurrentValue());
    }

    @Override
    public Optional<Portfolio> findById(UUID id) {
        return repo.findById(id)
                .map(e -> new Portfolio(e.getId(), e.getClientId(), e.getName(), e.getInvestedAmount(), e.getCurrentValue()));
    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
