package com.nwm.WealthCore.application.portfolio.port.in;

import java.util.UUID;

public interface CreatePortfolioUseCase {
    UUID create(UUID clientId, String name);
}
