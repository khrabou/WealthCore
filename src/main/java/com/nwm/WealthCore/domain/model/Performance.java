package com.nwm.WealthCore.domain.model;

import java.math.BigDecimal;

public record Performance(BigDecimal investedAmount, BigDecimal currentValue, BigDecimal benefit, BigDecimal performancePct) {
}
