package com.pnfe.dashboard.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cards")
public class CardEntity {

    @Id
    @Column(name = "card_id")
    private String id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "availablelimitamount")
    private long availableLimitAmount;
    @Column (name = "card_type")
    private String cardType;
    @Column (name = "pan")
    private String pan;
    @Column (name = "expdate")
    private String expDate;
    @Column (name = "cvc")
    private String cvc;
    @Column (name = "replenish_url")
    private String replenishUrl;
}
