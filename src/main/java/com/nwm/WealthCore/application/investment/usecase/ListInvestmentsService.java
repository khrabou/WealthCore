package com.nwm.WealthCore.application.investment.usecase;

import com.nwm.WealthCore.domain.model.Investment;
import com.nwm.WealthCore.application.investment.port.in.ListInvestmentsUseCase;
import com.nwm.WealthCore.application.investment.port.out.InvestmentRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListInvestmentsService implements ListInvestmentsUseCase {

    private final InvestmentRepositoryPort repo;

    public ListInvestmentsService(InvestmentRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public List<Investment> getAll(UUID portfolioId) {
        return repo.findByPortfolioId(portfolioId);
    }
}
