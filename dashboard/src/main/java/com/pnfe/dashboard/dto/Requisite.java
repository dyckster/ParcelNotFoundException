package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Requisite {
    @ApiModelProperty(required = true, value = "ИНН")
    private String inn;
    @ApiModelProperty(required = true, value = "ОГРНИП")
    private String ogrnip;
    @ApiModelProperty(required = true, value = "Номер счета")
    private String accountNumber;
    @ApiModelProperty(required = true, value = "БИК Банка")
    private String bankBik;
    @ApiModelProperty(required = true, value = "БИК Клиента")
    private String clientBik;
}
