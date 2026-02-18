package com.ana.patterns.strategy;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.service.ReportService;
import com.ana.patterns.strategy.strategy.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {

    private ReportData sample() {
        return new ReportData("My Report", LocalDate.of(2026, 2, 18), List.of("Line A", "Line B"));
    }

    @Test
    void shouldGenerateJsonReport() {
        ReportService service = new ReportService(new JsonReportStrategy());
        String out = service.generateReport(sample());

        assertTrue(out.startsWith("{"));
        assertTrue(out.contains("\"title\":\"My Report\""));
        assertTrue(out.contains("\"lines\""));
    }

    @Test
    void shouldGenerateHtmlReport() {
        ReportService service = new ReportService(new HtmlReportStrategy());
        String out = service.generateReport(sample());

        assertTrue(out.contains("<html>"));
        assertTrue(out.contains("<h1>My Report</h1>"));
        assertTrue(out.contains("<li>Line A</li>"));
    }

    @Test
    void shouldChangeStrategyAtRuntime() {
        ReportService service = new ReportService(new CsvReportStrategy());

        String csv = service.generateReport(sample());
        assertTrue(csv.contains("title,date,line"));

        service.changeStrategy(new XmlReportStrategy());
        String xml = service.generateReport(sample());
        assertTrue(xml.startsWith("<report>"));
        assertTrue(xml.contains("<title>My Report</title>"));
    }

    @Test
    void shouldSupportFakePdfWordExcel() {
        ReportData data = sample();

        assertTrue(new PdfReportStrategy().generate(data).contains("%PDF-FAKE"));
        assertTrue(new WordReportStrategy().generate(data).contains("WORD-DOC-FAKE"));
        assertTrue(new ExcelReportStrategy().generate(data).contains("TITLE\tDATE\tLINE"));
    }
}
