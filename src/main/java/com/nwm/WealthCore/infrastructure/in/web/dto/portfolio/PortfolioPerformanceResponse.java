package com.nwm.WealthCore.infrastructure.in.web.dto.portfolio;

import java.math.BigDecimal;

public class PortfolioPerformanceResponse {
    public BigDecimal investedAmount;
    public BigDecimal currentValue;
    public BigDecimal benefit;
    public BigDecimal performancePct;

    public PortfolioPerformanceResponse(BigDecimal investedAmount, BigDecimal currentValue, BigDecimal benefit, BigDecimal performancePct) {
        this.investedAmount = investedAmount;
        this.currentValue = currentValue;
        this.benefit = benefit;
        this.performancePct = performancePct;
    }
}
