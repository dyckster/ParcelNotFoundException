package com.pnfe.dashboard.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accounts")
public class AccountsEntity {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "inn")
    private String inn;
    @Column(name = "ogrnip")
    private String ogrnip;
    @Column(name = "accountnumber")
    private String accountNumber;
    @Column(name = "bik")
    private String bankBik;
    @Column(name = "client_bik")
    private String clientBik;
}
