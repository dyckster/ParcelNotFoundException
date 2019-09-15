package com.pnfe.dashboard.dto;

import lombok.Data;

import java.time.Month;
import java.util.List;
import java.util.Map;

@Data
public class TotalAmount {
    private Long totalCredit;
    private Long totalDebit;
    private Long totalTax;
    List<Map<Month,Long>> monthlyCredit;
    List<Map<Month,Long>> monthlyDebit;
    List<Map<Month,Long>> monthlyTax;
}
