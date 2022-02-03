package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "login")
public class Login implements Comparable<Login> {

	public Login() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "userName")
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String regId;
//	@NotNull
//	private ROLE role;

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}

}
