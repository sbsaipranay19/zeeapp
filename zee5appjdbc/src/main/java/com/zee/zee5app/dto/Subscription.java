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
	private String paymentMode;
	private String autoRenewal;
	private String expiryDate;
	@Setter(value = AccessLevel.NONE)
	private int subscripAmount;
	@Setter(value = AccessLevel.NONE)
	private String id;
	private String type;
	private String regId;

	public void setId(String id) throws InvalidIdLengthException {

		if (id.length() <= 6) {
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
		if (subscripAmount < 100) {
			throw new InvalidAmountException("Invalid Amount");
		}
		this.subscripAmount = subscripAmount;
	}

	public Subscription(String id, String DOP, String expiryDate, int subscripAmount, String paymentMode, String status,
			String type, String autoRenewal, String regId) throws InvalidIdLengthException, InvalidAmountException {
		super();
		this.setAutoRenewal(autoRenewal);
		this.setDOP(DOP);
		this.setExpiryDate(expiryDate);
		this.setId(id);
		this.setPaymentMode(paymentMode);
		this.setRegId(regId);
		this.setStatus(status);
		this.setSubscripAmount(subscripAmount);
		this.setType(type);
	}

	public Subscription() {
		// TODO Auto-generated constructor stub
	}

}
