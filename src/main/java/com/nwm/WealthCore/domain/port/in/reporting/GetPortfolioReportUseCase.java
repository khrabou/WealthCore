package com.nwm.WealthCore.domain.port.in.reporting;

import com.nwm.WealthCore.domain.model.Report;

import java.util.UUID;

public interface GetPortfolioReportUseCase {
    Report get(UUID portfolioId);
}
