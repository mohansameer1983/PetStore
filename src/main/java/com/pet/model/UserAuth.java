package com.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User Authentication/Authorization table-pojo mapping
 * 
 *
 */
@Entity
public class UserAuth {

	@Id
	private String username;
 
	private String password;
 
	private String role;
	
	public  UserAuth() {	
	}
	
	public UserAuth(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
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
 
	public String getRole() {
		return role;
	}
 
	public void setRole(String role) {
		this.role = role;
	}		
}
