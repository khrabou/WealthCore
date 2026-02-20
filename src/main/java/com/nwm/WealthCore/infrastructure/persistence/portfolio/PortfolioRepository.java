package com.nwm.WealthCore.infrastructure.persistence.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, UUID> {
}
