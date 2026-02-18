package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class ExcelReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.EXCEL;
    }

    @Override
    public String generate(ReportData data) {
        // Simulación tipo hoja: columnas separadas por TAB
        StringBuilder sb = new StringBuilder();
        sb.append("TITLE\tDATE\tLINE\n");
        for (String line : data.lines()) {
            sb.append(data.title()).append("\t")
                    .append(data.date()).append("\t")
                    .append(line).append("\n");
        }
        return sb.toString();
    }
}
