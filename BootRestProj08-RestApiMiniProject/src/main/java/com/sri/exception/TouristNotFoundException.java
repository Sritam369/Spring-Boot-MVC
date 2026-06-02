package com.sri.exception;

public class TouristNotFoundException extends RuntimeException{

	public TouristNotFoundException() {
		super();
	}
	public TouristNotFoundException(String msg) {
		super(msg);
	}
}
