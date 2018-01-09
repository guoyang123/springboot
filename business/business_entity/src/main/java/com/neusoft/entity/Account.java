package com.neusoft.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Account {
     @Setter@Getter
	 private Integer accountid;
	 private String username;
	 private String password;
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Account() {
		super();
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
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
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", username=" + username + ", password=" + password + "]";
	}
	
	 
	 
	 
}
