package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Login implements Comparable<Login> {

	public Login(String username, String password, String regId, ROLE role) {
		// TODO Auto-generated constructor stub
		this.setUserName(username);
		this.setPassword(password);
		this.setRegId(regId);
		this.setRole(role);
	}

	public Login() {
		// TODO Auto-generated constructor stub
	}

	private String userName;
	private String password;
	private String regId;
	private ROLE role;

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}

}
