package com.pnfe.dashboard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="operations")
public class OperationEntity {

    @Id
    @Column(name = "operation_id")
    private String id;
    @JsonIgnore
    @Column(name = "card_id")
    private String cardId;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "image")
    private String image;
    @Column(name = "oper_date")
    private LocalDate operDate;
    @JsonIgnore
    @Column(name = "credit_type")
    private String creditType;

}
