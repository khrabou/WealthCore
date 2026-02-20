package com.nwm.WealthCore.domain.port.in.investment;

import com.nwm.WealthCore.domain.model.Investment;

import java.util.List;
import java.util.UUID;

public interface ListInvestmentsUseCase {
    List<Investment> getAll(UUID portfolioId);
}
