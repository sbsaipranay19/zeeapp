package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Subscription implements Comparable<Subscription> {
	
	private String DOP;
	private String status;
	private String packCountry;
	private String paymentMode;
	private Boolean autoRenewal;
	private String expiryDate;
	@Setter(value = AccessLevel.NONE)
	private int subscripAmount;
	@Setter(value = AccessLevel.NONE)
	private String id;
	private String type;
	
	public void setId(String id) throws InvalidIdLengthException {
		
		if(id.length()<=6) {
			throw new InvalidIdLengthException("id length is lessthan or equal to 6");
		}
		this.id = id;
		
	}
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setSubscripAmount(int subscripAmount) throws InvalidAmountException {
		if(subscripAmount<500) {
			throw new  InvalidAmountException("Invalid Amount");
		}
		this.subscripAmount = subscripAmount;
	}
	
}
