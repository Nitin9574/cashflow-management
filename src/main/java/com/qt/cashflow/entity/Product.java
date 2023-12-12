package com.qt.cashflow.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String name;
    private String price;
    private String image;
    private String created_date;
    private String product_code;



}
