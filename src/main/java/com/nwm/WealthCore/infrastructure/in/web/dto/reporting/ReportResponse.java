package com.nwm.WealthCore.infrastructure.in.web.dto.reporting;

import com.nwm.WealthCore.infrastructure.in.web.dto.investment.InvestmentResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.portfolio.PortfolioPerformanceResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.portfolio.PortfolioResponse;

import java.util.List;

public class ReportResponse {

    public PortfolioResponse portfolio;
    public List<InvestmentResponse> investments;
    public PortfolioPerformanceResponse performance;

    public ReportResponse(PortfolioResponse portfolio, List<InvestmentResponse> investments, PortfolioPerformanceResponse performance) {
        this.portfolio = portfolio;
        this.investments = investments;
        this.performance = performance;
    }
}
