package com.online_shopping_management_spring.exception;

import java.util.Date;

import lombok.AllArgsConstructor; // Lombok annotation for generating constructors with all arguments
import lombok.Getter; // Lombok annotation for generating getter methods
import lombok.NoArgsConstructor; // Lombok annotation for generating a no-argument constructor
import lombok.Setter; // Lombok annotation for generating setter methods

@Getter // Lombok annotation for generating getter methods
@Setter // Lombok annotation for generating setter methods
@AllArgsConstructor // Lombok annotation for generating constructors with all arguments
@NoArgsConstructor // Lombok annotation for generating a no-argument constructor

public class ErrorDetails {

	private Date timestand; // Represents the timestamp when the error occurred
	private String message; // Represents the error message
	private String details; // Represents additional details about the error
}
