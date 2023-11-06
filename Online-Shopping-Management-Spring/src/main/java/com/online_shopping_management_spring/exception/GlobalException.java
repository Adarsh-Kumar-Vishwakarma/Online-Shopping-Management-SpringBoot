package com.online_shopping_management_spring.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // Indicates that this class provides global exception handling advice

public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class) // Handles exceptions of type ResourceNotFoundException
	public ResponseEntity<?> resourceNotFoundExHandling(ResourceNotFoundException resourceException,
			WebRequest webRequest) {
		// Create an ErrorDetails object with error details
		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceException.getMessage(),
				webRequest.getDescription(false));

		// Return a ResponseEntity with error details and a NOT_FOUND status
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
