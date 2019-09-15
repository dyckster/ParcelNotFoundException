package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OperationsView {
    @ApiModelProperty(required = true, value = "Статистика по операциям")
    private TotalAmount totalAmounts;
    @ApiModelProperty(required = true, value = "Список операций")
    private List<OperationView> operations;
}
