package com.pnfe.dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardData {
    private UserInfo user;
    private List<CardView> cards;
}
