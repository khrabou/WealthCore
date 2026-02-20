package com.nwm.WealthCore.domain.port.in.portfolio;

import java.util.UUID;

public interface CreatePortfolioUseCase {
    UUID create(UUID clientId, String name);
}
