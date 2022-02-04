package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "subscription")
public class Subscription implements Comparable<Subscription> {

	@Id
	@Column(name = "id")
	private String id;
	@NotNull
	private Date DOP;
	@NotNull
	private Date expiryDate;
	@NotNull
	private int subscripAmount;
	@NotBlank
	@Size(max = 10)
	private String paymentMode;
	@NotBlank
	@Size(max = 10)
	private String status;
	@NotBlank
	@Size(max = 10)
	private String type;
	@NotBlank
	@Size(max = 5)
	private String autoRenewal;
	

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne
	@JoinColumn(name = "regId")
	private Register register;

}
