package com.nwm.WealthCore.domain.model;

import java.util.List;

public record Report(
        Portfolio portfolio,
        List<Investment> investments,
        Performance performance
) {}
