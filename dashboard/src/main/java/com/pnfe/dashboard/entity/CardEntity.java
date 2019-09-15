package com.pnfe.dashboard.entity;

import com.pnfe.dashboard.dto.CardType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

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
    @Column (name = "exp_date")
    private LocalDate expDate;
    @Column (name = "cvc")
    private String cvc;
}
