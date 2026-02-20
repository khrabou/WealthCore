package com.nwm.WealthCore.infrastructure.in.web.dto.investment;

import java.math.BigDecimal;
import java.util.UUID;

public class InvestmentResponse {
    public UUID id;
    public String asset;
    public BigDecimal amount;

    public InvestmentResponse(UUID id, String asset, BigDecimal amount) {
        this.id = id;
        this.asset = asset;
        this.amount = amount;
    }
}
