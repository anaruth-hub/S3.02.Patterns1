package com.ana.patterns.strategy.app;

import com.ana.patterns.strategy.domain.ReportData;
import com.ana.patterns.strategy.service.ReportService;
import com.ana.patterns.strategy.strategy.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReportData data = new ReportData(
                "Weekly Sales",
                LocalDate.now(),
                List.of("Apples: 120", "Bananas: 95", "Oranges: 60")
        );

        ReportService service = new ReportService(new JsonReportStrategy());
        System.out.println(service.generateReport(data));

        service.changeStrategy(new HtmlReportStrategy());
        System.out.println(service.generateReport(data));
    }
}
