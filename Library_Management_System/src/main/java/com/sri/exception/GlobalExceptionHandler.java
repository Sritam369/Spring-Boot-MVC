package com.sri.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ExceptionDetails> getException(BookNotFoundException b) {
		
		ExceptionDetails e = new ExceptionDetails(LocalDateTime.now(),b.getMessage(),"No book available in the same id");
		
		return new ResponseEntity<ExceptionDetails>(e,HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(MemberNotFoundException.class)
	 public ResponseEntity<ExceptionDetails> handleMemberException(MemberNotFoundException ex) {

	        ExceptionDetails details = new ExceptionDetails(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "Member not found"
	        );

	        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(BorrowRecordNotFoundException.class)
	    public ResponseEntity<ExceptionDetails> handleBorrowRecordException(BorrowRecordNotFoundException ex) {

	        ExceptionDetails details = new ExceptionDetails(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "Borrow record not found"
	        );
	        
	        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
}
	    
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ExceptionDetails> handleException(Exception ex) {

	        ExceptionDetails details = new ExceptionDetails(
	                LocalDateTime.now(),
	                ex.getMessage(),
	                "Internal Server Error"
	        );

	        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
