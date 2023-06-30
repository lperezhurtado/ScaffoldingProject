package com.scaffolding.scaffolding.entities.beans;

import com.scaffolding.scaffolding.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithAccountBean {
    
    private UserEntity user;
    private AccountBean account;
    
}
