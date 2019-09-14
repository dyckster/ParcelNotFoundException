package com.parcelnotfound.backend.dto;

import lombok.Data;

@Data
public class Card {
    private String id;
    private String displayName;
    private long availableLimitAmount;
    private CardType cardType;
    private String panTail;

}
