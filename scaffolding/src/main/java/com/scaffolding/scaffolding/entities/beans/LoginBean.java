package com.scaffolding.scaffolding.entities.beans;

public class LoginBean {
    
    private String dni;
	private String password;
	
	public LoginBean () {}

	public LoginBean(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
