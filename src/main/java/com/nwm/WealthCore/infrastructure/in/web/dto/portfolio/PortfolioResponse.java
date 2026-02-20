package com.nwm.WealthCore.infrastructure.in.web.dto.portfolio;

import java.math.BigDecimal;
import java.util.UUID;

public class PortfolioResponse {
    public UUID id;
    public UUID clientId;
    public String name;
    public BigDecimal investedAmount;
    public BigDecimal currentValue;

    public PortfolioResponse(UUID id, UUID clientId, String name, BigDecimal investedAmount, BigDecimal currentValue) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.investedAmount = investedAmount;
        this.currentValue = currentValue;
    }
}
