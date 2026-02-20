package com.nwm.WealthCore.infrastructure.persistence.investment;

import com.nwm.WealthCore.domain.model.Investment;
import com.nwm.WealthCore.domain.port.out.InvestmentRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InvestmentRepositoryAdapter implements InvestmentRepositoryPort {

    private final InvestmentJpaRepository jpa;

    public InvestmentRepositoryAdapter(InvestmentJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Investment save(Investment inv) {
        InvestmentEntity saved = jpa.save(new InvestmentEntity(
                inv.getId(),
                inv.getPortfolioId(),
                inv.getAsset(),
                inv.getAmount()
        ));
        return new Investment(saved.getId(), saved.getPortfolioId(), saved.getAsset(), saved.getAmount());
    }

    @Override
    public List<Investment> findByPortfolioId(UUID portfolioId) {
        return jpa.findByPortfolioId(portfolioId).stream()
                .map(e -> new Investment(e.getId(), e.getPortfolioId(), e.getAsset(), e.getAmount()))
                .toList();
    }

    @Override
    public Optional<Investment> findById(UUID id) {
        return jpa.findById(id)
                .map(e -> new Investment(e.getId(), e.getPortfolioId(), e.getAsset(), e.getAmount()));
    }
}