package com.nwm.WealthCore.application.portfolio.port.in;

import com.nwm.WealthCore.domain.model.Portfolio;

import java.util.UUID;

public interface GetPortfolioUseCase {
    Portfolio get(UUID id);
}
