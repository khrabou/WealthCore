package com.nwm.WealthCore.domain.port.in.portfolio;

import java.util.UUID;

public interface DeletePortfolioUseCase {
    void delete(UUID id);
}
