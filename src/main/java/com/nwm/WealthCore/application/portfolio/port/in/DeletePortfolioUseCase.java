package com.nwm.WealthCore.application.portfolio.port.in;

import java.util.UUID;

public interface DeletePortfolioUseCase {
    void delete(UUID id);
}
