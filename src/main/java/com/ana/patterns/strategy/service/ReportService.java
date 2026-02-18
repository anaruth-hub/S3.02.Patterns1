package com.ana.patterns.strategy.service;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.strategy.ReportStrategy;

import java.util.Objects;

public final class ReportService {

    private ReportStrategy strategy;

    public ReportService(ReportStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy cannot be null");
    }

    public void changeStrategy(ReportStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy cannot be null");
    }

    public String generateReport(ReportData data) {
        Objects.requireNonNull(data, "data cannot be null");
        return strategy.generate(data);
    }
}
