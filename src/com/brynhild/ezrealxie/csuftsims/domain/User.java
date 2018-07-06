package com.brynhild.ezrealxie.csuftsims.domain;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3969992723561193160L;
	private String uidString;
	private String usernameString;
	private String passwordString;
	
	public String getID() {
		
		return uidString;		
	}
	
	public void setID(String uidString) {
		
		this.uidString = uidString;
		
	}
	
	public String getUsername() {
		
		return usernameString;
		
	}
	
	public void setUsername(String usernamesString) {
		
		this.usernameString = usernamesString;
		
	}
	
	public String getPassword() {
		
		return passwordString;
		
	}
	
	public void setPassword(String passwordString) {
		
		this.passwordString = passwordString;
		
	}
	
}
