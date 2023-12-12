package com.qt.cashflow.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Integer id;
    private String name;



}



