package com.scaffolding.scaffolding.entities.beans;

public class PasswordBean {
    
    private Long user;
    private String password;

    public PasswordBean() {}

    public PasswordBean(Long user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

    public Long getUser() {
        return user;
    }
    public void setUser(Long user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    } 
}
