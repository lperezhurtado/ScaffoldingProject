package com.scaffolding.scaffolding.entities.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedUserAccountBean {
    
    private IbanNumberBean iban;
    private String generatedPassword;
}
