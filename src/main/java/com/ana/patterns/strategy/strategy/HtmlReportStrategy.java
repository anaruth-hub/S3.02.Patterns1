package com.ana.patterns.strategy.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.domain.ReportFormat;

public final class HtmlReportStrategy implements ReportStrategy {

    @Override
    public ReportFormat format() {
        return ReportFormat.HTML;
    }

    @Override
    public String generate(ReportData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append("<h1>").append(escape(data.title())).append("</h1>");
        sb.append("<p>Date: ").append(data.date()).append("</p>");
        sb.append("<ul>");
        for (String line : data.lines()) {
            sb.append("<li>").append(escape(line)).append("</li>");
        }
        sb.append("</ul>");
        sb.append("</body></html>");
        return sb.toString();
    }

    private String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
