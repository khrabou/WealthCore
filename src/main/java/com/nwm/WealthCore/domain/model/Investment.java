package com.nwm.WealthCore.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Investment {

    private final UUID id;
    private final UUID portfolioId;
    private final String asset;
    private final BigDecimal amount;

    public Investment(UUID id, UUID portfolioId, String asset, BigDecimal amount) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.asset = asset;
        this.amount = amount;
    }

    public UUID getId() { return id; }
    public UUID getPortfolioId() { return portfolioId; }
    public String getAsset() { return asset; }
    public BigDecimal getAmount() { return amount; }


    public static Investment create(UUID portfolioId, String asset, BigDecimal amount) {
        return new Investment(UUID.randomUUID(), portfolioId, asset, amount);
    }

    public Investment updateAmount(BigDecimal newAmount) {
        return new Investment(id, portfolioId, asset, newAmount);
    }
}
