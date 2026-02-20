package com.nwm.WealthCore.infrastructure.persistence.investment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "investment")
public class InvestmentEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID portfolioId;

    @Column(nullable = false)
    private String asset;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    protected InvestmentEntity() {}

    public InvestmentEntity(UUID id, UUID portfolioId, String asset, BigDecimal amount) {
        this.id = id;
        this.portfolioId = portfolioId;
        this.asset = asset;
        this.amount = amount;
    }

    public UUID getId() { return id; }
    public UUID getPortfolioId() { return portfolioId; }
    public String getAsset() { return asset; }
    public BigDecimal getAmount() { return amount; }
}