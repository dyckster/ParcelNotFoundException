package com.pnfe.dashboard.dto;

import lombok.Data;

@Data
public class MonthAmount {
    private String month;
    private Long totalCredit;
    private Long totalDebit;
    private Long totalTax;
}
