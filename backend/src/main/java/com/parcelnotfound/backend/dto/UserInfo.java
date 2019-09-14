package com.parcelnotfound.backend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    @ApiModelProperty(required = true, value = "Полное имя пользователя")
    private String fullName;
    @ApiModelProperty(required = true, value = "Набор свойств пользователя: INDIVIDUAL,CORPORATE,SELF_EMPLOYED")
    private List<String> userProperties;

}
