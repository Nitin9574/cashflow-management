package com.qt.cashflow.dto;


import com.qt.cashflow.entity.Role;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class RegisterRequestDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private int age;
    private Date doj;
    private String job;
    private double mobileNumber;
    private String username;
    private String password;
    private Set<Role> roles;

}
