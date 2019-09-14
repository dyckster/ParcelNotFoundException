package com.pnfe.dashboard.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "profile_type")
    private String profileType;

}
