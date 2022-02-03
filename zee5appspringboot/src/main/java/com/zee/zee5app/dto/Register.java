package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register")
public class Register implements Comparable<Register> {

	@Id
	@Column(name = "regId")
	private String id;
	@Size(max = 50)
	@NotBlank
	private String firstName;
	@Size(max = 50)
	private String lastName;
	@Size(max = 50)
	@NotBlank
	private String email;
	@Size(max = 100)
	@NotBlank
	private String password;
	@NotNull
	private BigDecimal contactNumber;

	public Register() {

	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.id);
	}

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "regId"), 
	inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<>();

}