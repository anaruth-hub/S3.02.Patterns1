package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public interface ReportStrategy {
    ReportFormat format();
    String generate(ReportData data);
}
