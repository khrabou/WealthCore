package com.nwm.WealthCore.domain.port.in.investment;

import java.math.BigDecimal;
import java.util.UUID;

public interface UpdateInvestmentUseCase {
    void updateAmount(UUID investmentId, BigDecimal amount);
}
