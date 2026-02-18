package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class JsonReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.JSON;
    }

    @Override
    public String generate(ReportData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"title\":\"").append(escape(data.title())).append("\",");
        sb.append("\"date\":\"").append(data.date()).append("\",");
        sb.append("\"lines\":[");
        for (int i = 0; i < data.lines().size(); i++) {
            if (i > 0) sb.append(",");
            sb.append("\"").append(escape(data.lines().get(i))).append("\"");
        }
        sb.append("]}");
        return sb.toString();
    }

    private String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
