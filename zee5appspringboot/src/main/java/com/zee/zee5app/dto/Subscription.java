package com.zee.zee5app.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "subscription")
public class Subscription implements Comparable<Subscription> {

	@NotNull
	private Date DOP;
	@NotBlank
	@Size(max = 5)
	private String status;
	@NotBlank
	@Size(max = 10)
	private String paymentMode;
	@NotBlank
	@Size(max = 5)
	private String autoRenewal;
	@NotNull
	private Date expiryDate;
	@NotNull
	private int subscripAmount;
	@Id
	@Column(name = "id")
	private String id;
	@NotBlank
	@Size(max = 10)
	private String type;
	@NotBlank
	private String regId;

	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public Subscription() {
		// TODO Auto-generated constructor stub
	}

}
