package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CardView {
    @ApiModelProperty(required = true, value = "Идентификатор карты")
    private String id;
    @ApiModelProperty(required = true, value = "Название карты для отображения")
    private String displayName;
    @ApiModelProperty(required = true, value = "Доступный остаток")
    private long availableLimitAmount;
    @ApiModelProperty(required = true, value = "Тип карты: PLASTIC, VIRTUAL")
    private String cardType;
    @ApiModelProperty(required = true, value = "Окончание номера карты")
    private String panTail;
    @ApiModelProperty(required = true, value = "Ссылка для пополнения")
    private String replenishUrl;
    @ApiModelProperty(required = true, value = "Срок действия карты")
    private String expDate;
}
