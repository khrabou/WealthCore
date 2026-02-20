package com.nwm.WealthCore.application.investment;

import com.nwm.WealthCore.domain.model.Investment;
import com.nwm.WealthCore.domain.port.in.investment.UpdateInvestmentUseCase;
import com.nwm.WealthCore.domain.port.out.InvestmentRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class UpdateInvestmentService implements UpdateInvestmentUseCase {

    private final InvestmentRepositoryPort repo;

    public UpdateInvestmentService(InvestmentRepositoryPort repo) {
        this.repo = repo;
    }
    @Override
    @Transactional
    public void updateAmount(UUID id, BigDecimal amount) {
        if (amount == null || amount.signum() <= 0)
            throw new IllegalArgumentException("amount must be positive");

        Investment inv = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Investment not found"));

        repo.save(inv.updateAmount(amount));
    }
}
