package com.scaffolding.scaffolding.entities.beans;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserBean {
    
    private Long uid;

    private String name;
    private String lastName;
    private String dni;
    private LocalDate birth;
    private String adress;
    private int postalCode;
    private String email;

}