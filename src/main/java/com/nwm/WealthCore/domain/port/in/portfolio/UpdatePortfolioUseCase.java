package com.nwm.WealthCore.domain.port.in.portfolio;

import java.util.UUID;

public interface UpdatePortfolioUseCase {
    void rename(UUID id, String name);
}
