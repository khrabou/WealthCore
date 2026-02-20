package com.nwm.WealthCore.infrastructure.in.web.controller;

import com.nwm.WealthCore.domain.model.Report;
import com.nwm.WealthCore.application.reporting.port.in.GetPortfolioReportUseCase;
import com.nwm.WealthCore.infrastructure.in.web.dto.investment.InvestmentResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.portfolio.PortfolioPerformanceResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.portfolio.PortfolioResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.reporting.ReportResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ReportingController {

    private final GetPortfolioReportUseCase report;

    public ReportingController(GetPortfolioReportUseCase report) {
        this.report = report;
    }



    @GetMapping("/api/portfolios/{portfolioId}/report")
    public ReportResponse get(@PathVariable UUID portfolioId) {
        Report r = report.get(portfolioId);

        var p = r.portfolio();
        var perf = r.performance();

        PortfolioResponse portfolioDto =
                new PortfolioResponse(p.getId(), p.getClientId(), p.getName(), p.getInvestedAmount(), p.getCurrentValue());

        var investmentsDto = r.investments().stream()
                .map(i -> new InvestmentResponse(i.getId(), i.getAsset(), i.getAmount()))
                .toList();

        PortfolioPerformanceResponse performanceDto =
                new PortfolioPerformanceResponse(
                        perf.investedAmount(),
                        perf.currentValue(),
                        perf.benefit(),
                        perf.performancePct()
                );

        return new ReportResponse(portfolioDto, investmentsDto, performanceDto);
    }
}
