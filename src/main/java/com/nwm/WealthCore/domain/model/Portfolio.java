package com.nwm.WealthCore.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Portfolio {
    private final UUID id;
    private final UUID clientId;
    private final String name;
    private final BigDecimal investedAmount;
    private final BigDecimal currentValue;

    public Portfolio(UUID id, UUID clientId, String name, BigDecimal investedAmount, BigDecimal currentValue) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.investedAmount = investedAmount;
        this.currentValue = currentValue;
    }

    public UUID getId() { return id; }
    public UUID getClientId() { return clientId; }
    public String getName() { return name; }
    public BigDecimal getInvestedAmount() { return investedAmount; }
    public BigDecimal getCurrentValue() { return currentValue; }
    public static Portfolio create(UUID clientId, String name) {
        return new Portfolio(UUID.randomUUID(), clientId, name, BigDecimal.ZERO, BigDecimal.ZERO);
    }
    public Portfolio rename(String newName) {
        return new Portfolio(id, clientId, newName, investedAmount, currentValue);
    }
}
