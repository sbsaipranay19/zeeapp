package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "login")
public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "userName")
	private String userName;
	@NotBlank
	private String password;
//	@NotNull
//	private ROLE role;

	
	
	@OneToOne(fetch = FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//	@JsonSerialize(using = CustomListSerializer.class
//	@Getter(value = AccessLevel.NONE)
	@JoinColumn(name = "regId", nullable = false, foreignKey = @ForeignKey(name = "fk_logregId"))
	@JsonProperty(access = Access.WRITE_ONLY)
	private Register register;

}
