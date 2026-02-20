package com.nwm.WealthCore.application.investment.usecase;

import com.nwm.WealthCore.domain.model.Investment;
import com.nwm.WealthCore.application.investment.port.in.CreateInvestmentUseCase;
import com.nwm.WealthCore.application.investment.port.out.InvestmentRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CreateInvestmentService implements CreateInvestmentUseCase {
    private final InvestmentRepositoryPort repo;

    public CreateInvestmentService(InvestmentRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public UUID create(UUID portfolioId, String asset, BigDecimal amount) {

        if (asset == null || asset.isBlank()) throw new IllegalArgumentException("asset required");
        if (amount == null || amount.signum() <= 0) throw new IllegalArgumentException("amount must be positive");

        Investment saved = repo.save(Investment.create(portfolioId, asset, amount));
        return saved.getId();
    }
}
