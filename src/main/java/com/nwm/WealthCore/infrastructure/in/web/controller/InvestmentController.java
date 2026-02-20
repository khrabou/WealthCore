package com.nwm.WealthCore.infrastructure.in.web.controller;

import com.nwm.WealthCore.application.investment.port.in.CreateInvestmentUseCase;
import com.nwm.WealthCore.application.investment.port.in.ListInvestmentsUseCase;
import com.nwm.WealthCore.application.investment.port.in.UpdateInvestmentUseCase;
import com.nwm.WealthCore.infrastructure.in.web.dto.investment.CreateInvestmentRequest;
import com.nwm.WealthCore.infrastructure.in.web.dto.investment.InvestmentResponse;
import com.nwm.WealthCore.infrastructure.in.web.dto.investment.UpdateInvestmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class InvestmentController {

    private final CreateInvestmentUseCase createInvestment;
    private final ListInvestmentsUseCase listInvestments;
    private final UpdateInvestmentUseCase updateInvestment;


    public InvestmentController(CreateInvestmentUseCase createInvestment, ListInvestmentsUseCase listInvestments, UpdateInvestmentUseCase updateInvestment) {
        this.createInvestment = createInvestment;
        this.listInvestments = listInvestments;
        this.updateInvestment = updateInvestment;
    }


    @PostMapping("/api/portfolios/{portfolioId}/investments")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@PathVariable UUID portfolioId,
                       @RequestBody CreateInvestmentRequest req) {
        return createInvestment.create(portfolioId, req.asset, req.amount);
    }

    @GetMapping("/api/portfolios/{portfolioId}/investments")
    public List<InvestmentResponse> getAll(@PathVariable UUID portfolioId) {
        return listInvestments.getAll(portfolioId).stream()
                .map(i -> new InvestmentResponse(i.getId(), i.getAsset(), i.getAmount()))
                .toList();
    }

    @PutMapping("/api/investments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id,
                       @RequestBody UpdateInvestmentRequest req) {
        updateInvestment.updateAmount(id, req.amount);
    }
}
