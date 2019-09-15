package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OperationView {
    @ApiModelProperty(required = true, value = "Идентификатор операции")
    private String id;
    @ApiModelProperty(required = true, value = "Название операции")
    private String displayName;
    @ApiModelProperty(value = "Дополнительное описание операции")
    private String subtitle;
    @ApiModelProperty(required = true, value = "Пиктограмма для отображения")
    private String image;
    @ApiModelProperty(required = true, value = "Дата операции")
    private LocalDate operDate;
    @ApiModelProperty(required = true, value = "Сумма операции (в копейках)")
    private Long amount;
    @ApiModelProperty(required = true, value = "Сумма налога (в копейках)")
    private long taxAmount;
    @ApiModelProperty(required = true, value = "Процент налога")
    private double taxPercent;

}
