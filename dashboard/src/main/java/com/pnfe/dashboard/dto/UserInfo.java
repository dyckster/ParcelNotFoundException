package com.pnfe.dashboard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    @ApiModelProperty(required = true, value = "Полное имя пользователя")
    private String fullName;
    @ApiModelProperty(required = true, value = "Тип пользователя: INDIVIDUAL,CORPORATE,SELF_EMPLOYED")
    private String profileType;

}
