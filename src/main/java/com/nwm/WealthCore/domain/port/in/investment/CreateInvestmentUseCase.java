package com.nwm.WealthCore.domain.port.in.investment;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateInvestmentUseCase {
    UUID create(UUID portfolioId, String asset, BigDecimal amount);
}
