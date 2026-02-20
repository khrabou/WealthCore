package com.nwm.WealthCore.application.reporting;

import com.nwm.WealthCore.application.portfolio.GetPortfolioPerformanceService;
import com.nwm.WealthCore.domain.model.Investment;
import com.nwm.WealthCore.domain.model.Performance;
import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.model.Report;
import com.nwm.WealthCore.domain.port.in.reporting.GetPortfolioReportUseCase;
import com.nwm.WealthCore.domain.port.out.InvestmentRepositoryPort;
import com.nwm.WealthCore.domain.port.out.PortfolioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetPortfolioReportService implements GetPortfolioReportUseCase {
    private final PortfolioRepositoryPort portfolioRepo;
    private final InvestmentRepositoryPort investmentRepo;
    private final GetPortfolioPerformanceService performanceService;

    public GetPortfolioReportService(PortfolioRepositoryPort portfolioRepo, InvestmentRepositoryPort investmentRepo, GetPortfolioPerformanceService performanceService) {
        this.portfolioRepo = portfolioRepo;
        this.investmentRepo = investmentRepo;
        this.performanceService = performanceService;
    }


    @Override
    public Report get(UUID portfolioId) {
        Portfolio p = portfolioRepo.findById(portfolioId)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));

        List<Investment> investments = investmentRepo.findByPortfolioId(portfolioId);

        Performance perf = performanceService.get(portfolioId);

        return new Report(p, investments, perf);
    }
}
