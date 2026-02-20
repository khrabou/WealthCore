package com.nwm.WealthCore.infrastructure.out.persistence.investment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvestmentJpaRepository extends JpaRepository<InvestmentEntity, UUID> {
    List<InvestmentEntity> findByPortfolioId(UUID portfolioId);
}
