package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ClaimException.class)
	public ResponseEntity<ErrorHandle> claimExceptionHandler(ClaimException se, WebRequest req){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	}
	
	@ExceptionHandler(ClientException.class)
	public ResponseEntity<ErrorHandle> ClientExceptionHandler(ClientException se, WebRequest req){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	}
	

	@ExceptionHandler(InsuaranceException.class)
	public ResponseEntity<ErrorHandle> InsuaranceExceptionHandler(InsuaranceException se, WebRequest req){
		
		
		ErrorHandle err= new ErrorHandle();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorHandle>(err, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	
}