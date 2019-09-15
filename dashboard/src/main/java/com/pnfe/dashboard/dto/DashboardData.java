package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DashboardData {
    @ApiModelProperty(required = true, value = "Сведения о пользователе")
    private UserInfo user;
    @ApiModelProperty(value = "Данные о тратах в текущем месяце")
    private TimelineSummary timelineSummary;
    @ApiModelProperty(required = true, value = "Информация об открытых счетах")
    private List<Account> accounts;
}
