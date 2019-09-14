package com.parcelnotfound.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cardlist")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
}
