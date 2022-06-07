package com.techvify.loginBasic.dto;


import com.techvify.loginBasic.entity.User;

public class CreateUserDTO {
	
	private String username;
	
	private String password;
	
	public User toEntity() {
		return new User(username,password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
