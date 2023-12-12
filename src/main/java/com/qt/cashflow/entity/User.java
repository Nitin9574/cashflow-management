package com.qt.cashflow.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name = "doj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doj;
    @Column(name = "job")
    private String job;
    @Column(name = "mobilenumber")
    private double mobileNumber;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;




    @ManyToMany
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
