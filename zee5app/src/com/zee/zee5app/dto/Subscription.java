package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {
	private String DOP;
	private String status;
	private String packCountry;
	private String paymentMode;
	private Boolean autoRenewal;
	private String expiryDate;
	private String id;
}
