package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class CsvReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.CSV;
    }

    @Override
    public String generate(ReportData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("title,date,line\n");
        for (String line : data.lines()) {
            sb.append(csv(data.title())).append(",");
            sb.append(data.date()).append(",");
            sb.append(csv(line)).append("\n");
        }
        return sb.toString();
    }

    private String csv(String s) {
        String escaped = s.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}
