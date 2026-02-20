package com.nwm.WealthCore.application.investment.port.in;

import com.nwm.WealthCore.domain.model.Investment;

import java.util.List;
import java.util.UUID;

public interface ListInvestmentsUseCase {
    List<Investment> getAll(UUID portfolioId);
}
