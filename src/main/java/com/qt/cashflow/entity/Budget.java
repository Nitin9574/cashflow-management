package com.qt.cashflow.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String food;
    private String fuel;
    private String groceries;
    private String toiletries;
    private String vegetables;
    private String clothes;
    private String telephone_bill;
    private String room_rents;
}
