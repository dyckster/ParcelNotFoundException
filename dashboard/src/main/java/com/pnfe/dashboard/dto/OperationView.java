package com.pnfe.dashboard.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OperationView {
    private String id;
    private String displayName;
    private String subtitle;
    private String image;
    private LocalDate operDate;
    private Long amount;
    private long taxAmount;
    private double taxPercent;

}
