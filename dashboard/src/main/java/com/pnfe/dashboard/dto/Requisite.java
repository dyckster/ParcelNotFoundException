package com.pnfe.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Requisite {
    private String inn;
    private String ogrnip;
    private String accountNumber;
    private String bankBik;
    private String clientBik;
}
