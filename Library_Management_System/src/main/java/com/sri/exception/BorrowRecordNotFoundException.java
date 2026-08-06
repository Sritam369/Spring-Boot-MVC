package com.sri.exception;

public class BorrowRecordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BorrowRecordNotFoundException() {
		super();
	}
	public BorrowRecordNotFoundException(String msg) {
		super(msg);
	}
}
