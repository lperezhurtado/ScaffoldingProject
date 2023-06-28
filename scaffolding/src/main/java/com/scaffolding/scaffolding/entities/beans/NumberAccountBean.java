package com.scaffolding.scaffolding.entities.beans;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberAccountBean {
    
    private String account;
    private LocalDateTime openingDate;
    
}
