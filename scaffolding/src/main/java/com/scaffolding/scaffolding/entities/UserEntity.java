package com.scaffolding.scaffolding.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitialize", "handler"})
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;
    private String lastName;
    private String dni;
    private LocalDate birth = null;
    private String adress = null;
    private int postalCode;
    private String email = null;

}
