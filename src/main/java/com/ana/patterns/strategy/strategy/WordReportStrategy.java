package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class WordReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.WORD;
    }

    @Override
    public String generate(ReportData data) {
        return """
               WORD-DOC-FAKE
               [Heading] %s
               [Date] %s
               %s
               """.formatted(data.title(), data.date(), bulletLines(data));
    }

    private String bulletLines(ReportData data) {
        StringBuilder sb = new StringBuilder();
        for (String line : data.lines()) {
            sb.append("• ").append(line).append("\n");
        }
        return sb.toString();
    }
}
