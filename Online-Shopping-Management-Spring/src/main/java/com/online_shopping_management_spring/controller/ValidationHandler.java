package com.online_shopping_management_spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Indicates that this class is a Spring ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	// Override the method to handle validation errors
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// Create a map to store validation errors
		Map<String, String> errors = new HashMap<>();
		
		// Iterate through validation errors and store them in the map
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		// Return a ResponseEntity with validation errors and a BAD_REQUEST status
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
