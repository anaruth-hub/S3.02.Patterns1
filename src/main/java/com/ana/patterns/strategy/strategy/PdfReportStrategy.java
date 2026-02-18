package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class PdfReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.PDF;
    }

    @Override
    public String generate(ReportData data) {
        return """
               %%PDF-FAKE
               TITLE: %s
               DATE: %s
               CONTENT:
               %s
               %%EOF
               """.formatted(
                data.title(),
                data.date(),
                String.join("\n", data.lines())
        );
    }
}
