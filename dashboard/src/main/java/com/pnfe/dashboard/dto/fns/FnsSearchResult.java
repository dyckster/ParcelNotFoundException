package com.pnfe.dashboard.dto.fns;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FnsSearchResult {
    @JsonProperty("ЮЛ")
    private FnsCompanyDescription company;
    @JsonProperty("ИП")
    private FnsCompanyDescription enterpreneur;
}
