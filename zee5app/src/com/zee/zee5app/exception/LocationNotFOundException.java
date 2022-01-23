package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class LocationNotFOundException extends Exception {
	public LocationNotFOundException(String msg) {
		super(msg);
	}
}
