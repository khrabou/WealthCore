package com.nwm.WealthCore.application.portfolio.port.out;

import com.nwm.WealthCore.domain.model.Portfolio;

import java.util.Optional;
import java.util.UUID;

public interface PortfolioRepositoryPort {
    Portfolio save(Portfolio portfolio);
    Optional<Portfolio> findById(UUID id);
    boolean existsById(UUID id);
    void deleteById(UUID id);
}
