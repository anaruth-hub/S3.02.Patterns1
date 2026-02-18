package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class XmlReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.XML;
    }

    @Override
    public String generate(ReportData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<report>");
        sb.append("<title>").append(escape(data.title())).append("</title>");
        sb.append("<date>").append(data.date()).append("</date>");
        sb.append("<lines>");
        for (String line : data.lines()) {
            sb.append("<line>").append(escape(line)).append("</line>");
        }
        sb.append("</lines>");
        sb.append("</report>");
        return sb.toString();
    }

    private String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
