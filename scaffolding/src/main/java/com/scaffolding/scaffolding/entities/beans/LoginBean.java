package com.scaffolding.scaffolding.entities.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {
    
    private String dni;
	private String password;
	
}
