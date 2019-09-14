package com.pnfe.dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class Account {
    private String accountId;
    private Requisite requisites;
    private List<CardView> cards;
}
