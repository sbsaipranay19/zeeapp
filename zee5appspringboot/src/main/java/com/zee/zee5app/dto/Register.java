package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//AllArgsConstructor
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
	@NotBlank
	private BigDecimal contactNumber;

	public Register() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.id);
	}

}