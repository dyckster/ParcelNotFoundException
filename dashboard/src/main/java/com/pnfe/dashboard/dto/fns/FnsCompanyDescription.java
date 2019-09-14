package com.pnfe.dashboard.dto.fns;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FnsCompanyDescription {
    @JsonProperty("ИНН")
    private String inn;
    @JsonProperty("ОГРН")
    private String ogrn;
    @JsonProperty("НаимСокрЮЛ")
    private String shortName;
    @JsonProperty("НаимПолнЮЛ")
    private String fullName;
    @JsonProperty("ФИОПолн")
    private String fullFio;
    @JsonProperty("ДатаРег")
    private String openDate;
    @JsonProperty("Статус")
    private String status;
    @JsonProperty("ДатаПрекр")
    private String closeDate;
    @JsonProperty("АдресПолн")
    private String fullAddress;
    @JsonProperty("ОснВидДеят")
    private String mainOccupation;

}
