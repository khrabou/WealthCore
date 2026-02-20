package com.nwm.WealthCore.infrastructure.out.persistence.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, UUID> {
}
