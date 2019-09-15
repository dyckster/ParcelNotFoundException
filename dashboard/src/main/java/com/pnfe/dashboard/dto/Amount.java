package com.pnfe.dashboard.dto;

import lombok.Data;

@Data
public class Amount {
    private Long amount;
    private long taxAmount;
    private double taxPercent;
}
