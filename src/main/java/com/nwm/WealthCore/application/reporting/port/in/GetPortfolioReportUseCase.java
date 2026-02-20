package com.nwm.WealthCore.application.reporting.port.in;

import com.nwm.WealthCore.domain.model.Report;

import java.util.UUID;

public interface GetPortfolioReportUseCase {
    Report get(UUID portfolioId);
}
