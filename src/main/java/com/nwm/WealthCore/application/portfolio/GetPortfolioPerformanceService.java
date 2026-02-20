package com.nwm.WealthCore.application.portfolio;

import com.nwm.WealthCore.domain.model.Performance;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.in.portfolio.GetPortfolioPerformanceUseCase;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class GetPortfolioPerformanceService implements GetPortfolioPerformanceUseCase {
    private final PortfolioRepositoryPort repo;

    public GetPortfolioPerformanceService(PortfolioRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public Performance get(UUID id) {
        Portfolio p = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));

        BigDecimal invested = p.getInvestedAmount() == null ? BigDecimal.ZERO : p.getInvestedAmount();
        BigDecimal current = p.getCurrentValue() == null ? BigDecimal.ZERO : p.getCurrentValue();

        BigDecimal benefit = current.subtract(invested);

        BigDecimal pct;
        if (invested.compareTo(BigDecimal.ZERO) == 0) {
            pct = BigDecimal.ZERO;
        } else {
            pct = benefit.divide(invested)
                    .multiply(BigDecimal.valueOf(100));
        }

        return new Performance(invested, current, benefit, pct);
    }
}
