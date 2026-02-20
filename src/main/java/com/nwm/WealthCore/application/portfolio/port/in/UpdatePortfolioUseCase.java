package com.nwm.WealthCore.application.portfolio.port.in;

import java.util.UUID;

public interface UpdatePortfolioUseCase {
    void rename(UUID id, String name);
}
