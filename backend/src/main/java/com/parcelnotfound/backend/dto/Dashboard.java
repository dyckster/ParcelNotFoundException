package com.parcelnotfound.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class Dashboard {
    private UserInfo user;
    private List<Account> accounts;
    private List<Card> cards;
}
