package com.pinto.ReactEcommerceBackend.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException excep, WebRequest request){
		Map<String,Object> body = new HashMap<>();
		body.put("Timestamp", Instant.now());
		body.put("Status",HttpStatus.NOT_FOUND.value());
		body.put("Message",excep.getMessage());
		body.put("Path", request.getDescription(false).replace("uri=", ""));
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> handleGlobalException(ResourceNotFoundException excep, WebRequest request){
		
		Map<String,Object> body=new HashMap<>();
		body.put("Timestamp", Instant.now());
		body.put("Status", HttpStatus.NOT_FOUND.value());
		body.put("Message", excep.getMessage());
		body.put("Path", request.getDescription(false).replace("uri=",""));
		
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	
}
