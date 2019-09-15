package com.pnfe.dashboard.dto;

import com.pnfe.dashboard.entity.OperationEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OperationView {
    private String id;
    private String displayName;
    private String subtitle;
    private String image;
    private LocalDate operDate;
    private Amount operationAmount;

}
