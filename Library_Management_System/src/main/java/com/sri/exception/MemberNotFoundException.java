package com.sri.exception;

public class MemberNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MemberNotFoundException() {
		super();
	}
	public MemberNotFoundException(String msg) {
		super(msg);
	}
}