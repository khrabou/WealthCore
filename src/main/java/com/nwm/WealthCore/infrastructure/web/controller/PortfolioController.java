package com.nwm.WealthCore.infrastructure.web.controller;

import com.nwm.WealthCore.domain.model.Portfolio;
import com.nwm.WealthCore.domain.port.in.portfolio.*;
import com.nwm.WealthCore.infrastructure.web.dto.portfolio.CreatePortfolioRequest;
import com.nwm.WealthCore.infrastructure.web.dto.portfolio.PortfolioPerformanceResponse;
import com.nwm.WealthCore.infrastructure.web.dto.portfolio.PortfolioResponse;
import com.nwm.WealthCore.infrastructure.web.dto.portfolio.UpdatePortfolioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    private final CreatePortfolioUseCase createPortfolio;
    private final GetPortfolioUseCase getPortfolio;
    private final UpdatePortfolioUseCase updatePortfolio;
    private final DeletePortfolioUseCase deletePortfolio;
    private final GetPortfolioPerformanceUseCase getPortfolioPerformance;

    public PortfolioController(CreatePortfolioUseCase createPortfolio, GetPortfolioUseCase getPortfolio, UpdatePortfolioUseCase updatePortfolio, DeletePortfolioUseCase deletePortfolio, GetPortfolioPerformanceUseCase getPortfolioPerformanceUseCase) {
        this.createPortfolio = createPortfolio;
        this.getPortfolio = getPortfolio;
        this.updatePortfolio = updatePortfolio;
        this.deletePortfolio = deletePortfolio;
        this.getPortfolioPerformance = getPortfolioPerformanceUseCase;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, UUID> create(@RequestBody CreatePortfolioRequest req) {
        UUID id = createPortfolio.create(req.clientId, req.name);
        return Map.of("id", id);
    }

    @GetMapping("/{id}")
    public PortfolioResponse get(@PathVariable UUID id) {
        Portfolio p = getPortfolio.get(id);
        return new PortfolioResponse(p.getId(), p.getClientId(), p.getName(), p.getInvestedAmount(), p.getCurrentValue());
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void rename(@PathVariable UUID id, @RequestBody UpdatePortfolioRequest req) {
        updatePortfolio.rename(id, req.name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        deletePortfolio.delete(id);
    }

    @GetMapping("/{id}/performance")
    public PortfolioPerformanceResponse getPerformance(@PathVariable UUID id) {
        var p = getPortfolioPerformance.get(id);
        return new PortfolioPerformanceResponse(
                p.investedAmount(), p.currentValue(), p.benefit(), p.performancePct()
        );
    }
}
