package com.nwm.WealthCore.application.portfolio.port.in;

import com.nwm.WealthCore.domain.model.Performance;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface GetPortfolioPerformanceUseCase {

    Performance get(UUID id);
}
