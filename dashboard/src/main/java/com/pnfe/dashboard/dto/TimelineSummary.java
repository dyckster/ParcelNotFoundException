package com.pnfe.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimelineSummary {
    private Long currentMonthCredit;
    private Long currentMonthTax;
}
