package com.pnfe.dashboard.dto;

import lombok.Data;

@Data
public class CardView {
    private String id;
    private String displayName;
    private long availableLimitAmount;
    private String cardType;
    private String panTail;
}
