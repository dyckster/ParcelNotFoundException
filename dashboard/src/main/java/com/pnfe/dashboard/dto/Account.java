package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Account {
    @ApiModelProperty(required = true, value = "Идентификатор счета")
    private String accountId;
    @ApiModelProperty(required = true, value = "Реквизиты счета")
    private Requisite requisites;
    @ApiModelProperty(required = true, value = "Перечень карт к счету")
    private List<CardView> cards;
}
