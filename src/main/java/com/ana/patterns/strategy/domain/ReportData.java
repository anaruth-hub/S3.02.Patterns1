package com.ana.patterns.strategy.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record ReportData(String title, LocalDate date, List<String> lines) {

    public ReportData {
        Objects.requireNonNull(title, "title cannot be null");
        Objects.requireNonNull(date, "date cannot be null");
        Objects.requireNonNull(lines, "lines cannot be null");
        if (title.isBlank()) throw new IllegalArgumentException("title cannot be blank");
    }
}
