package com.pnfe.dashboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CardRequisites {

    @JsonIgnore
    private String id;

    @ApiModelProperty(required = true, value = "Номер карты")
    private String pan;
    @ApiModelProperty(required = true, value = "Срок действия карты")
    private String expDate;
    @ApiModelProperty(required = true, value = "Секретный код")
    private String cvc;
}
