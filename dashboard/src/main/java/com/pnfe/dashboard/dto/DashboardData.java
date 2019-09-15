package com.pnfe.dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class DashboardData {
    private UserInfo user;
    private TimelineSummary timelineSummary;
    private List<Account> accounts;
}
