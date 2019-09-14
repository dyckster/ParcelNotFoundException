package com.parcelnotfound.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CardRequisites {
    
    @JsonIgnore
    private String id;
    
    private String pan;
    private String expDate;
    private String cvc;
}
