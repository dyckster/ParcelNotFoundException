package com.pnfe.dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class OperationsView {
    private TotalAmount totalAmounts;
    private List<OperationView> operations;
}
