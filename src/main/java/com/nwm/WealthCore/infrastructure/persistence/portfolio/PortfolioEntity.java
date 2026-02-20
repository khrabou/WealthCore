package com.nwm.WealthCore.infrastructure.persistence.portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
public class PortfolioEntity {

    @Id
    private UUID id;
    @Column(nullable = false)
    private UUID clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal investedAmount;

    @Column(nullable = false)
    private BigDecimal currentValue;

    protected PortfolioEntity() {}

    public PortfolioEntity(UUID id, UUID clientId, String name, BigDecimal investedAmount, BigDecimal currentValue) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.investedAmount = investedAmount;
        this.currentValue = currentValue;
    }

    public UUID getId() { return id; }
    public UUID getClientId() { return clientId; }
    public String getName() { return name; }

    public BigDecimal getInvestedAmount() {
        return investedAmount;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }
}
