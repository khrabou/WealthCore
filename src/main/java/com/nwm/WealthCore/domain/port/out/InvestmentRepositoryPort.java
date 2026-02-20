package com.nwm.WealthCore.domain.port.out;

import com.nwm.WealthCore.domain.model.Investment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvestmentRepositoryPort {

    Investment save(Investment investment);
    List<Investment> findByPortfolioId(UUID portfolioId);

    Optional<Investment> findById(UUID id);

}
