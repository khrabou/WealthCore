package com.nwm.WealthCore.application.investment.port.in;

import java.math.BigDecimal;
import java.util.UUID;

public interface UpdateInvestmentUseCase {
    void updateAmount(UUID investmentId, BigDecimal amount);
}
