package com.nwm.WealthCore.domain.port.in.portfolio;

import com.nwm.WealthCore.domain.model.Portfolio;

import java.util.UUID;

public interface GetPortfolioUseCase {
    Portfolio get(UUID id);
}
