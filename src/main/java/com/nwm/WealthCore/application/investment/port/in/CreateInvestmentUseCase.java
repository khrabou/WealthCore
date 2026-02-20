package com.nwm.WealthCore.application.investment.port.in;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateInvestmentUseCase {
    UUID create(UUID portfolioId, String asset, BigDecimal amount);
}
