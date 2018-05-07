package com.bean;

public class User {

	private String name;
	private String password;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User (String password,String name,String email){
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
		
	}
	public User (String password,String email){
		this.setPassword(password);
		this.setEmail(email);
		
	}

}
