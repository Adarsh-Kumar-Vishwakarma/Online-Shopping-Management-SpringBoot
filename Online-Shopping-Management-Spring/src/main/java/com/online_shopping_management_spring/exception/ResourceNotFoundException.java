package com.online_shopping_management_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // Specifies that this exception should result in a NOT_FOUND HTTP response status

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; // A unique identifier for serialization

	private String resourceName; // Represents the name of the resource that was not found
	private String fieldName; // Represents the name of the field causing the exception
	private Object fieldValue; // Represents the value of the field causing the exception

	// Constructor for the ResourceNotFoundException
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s: '%s' ", resourceName, fieldName, fieldValue));
		// Initialize the exception message using resource name, field name, and field value
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
