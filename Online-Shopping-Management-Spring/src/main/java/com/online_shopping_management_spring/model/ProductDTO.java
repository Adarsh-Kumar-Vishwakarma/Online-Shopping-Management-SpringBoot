package com.online_shopping_management_spring.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.websocket.OnMessage;

import org.hibernate.validator.constraints.UniqueElements;

import com.online_shopping_management_spring.entity.OrderEntity;

import lombok.Getter; // Lombok annotation for generating getter methods
import lombok.Setter; // Lombok annotation for generating setter methods

@Getter // Lombok annotation for generating getter methods
@Setter // Lombok annotation for generating setter methods

public class ProductDTO {
	@NotNull // Specifies that the field must not be null
	private int productId; // Represents the unique identifier for the product

	@NotNull // Specifies that the field must not be null
	@Size(min = 2, max = 50, message = "YOUR NAME SHOULD BE MINIMUM 2 OR MAXIMUM 50 CHARACTERS...")
	//@Min(value = 2, message = "YOUR PRODUCT NAME SHOULD BE MINIMUM 2 CHARACTERS...")
    //@Max(value = 50, message = "YOUR PRODUCT NAME SHOULD BE MAXIMUM 50 CHARACTERS...")
	private String productName; // Represents the name of the product with validation constraints

	@NotNull // Specifies that the field must not be null
	@Size(min = 10, max = 100, message = "YOUR ADDRESS SHOULD BE MINIMUM 10 OR MAXIMUM 100 CHARACTERS...")
    //@Max(value = 100, message = "YOUR ADDRESS SHOULD BE MAXIMUM 100 CHARACTERS...")
	//@Min(value = 10, message = "YOUR ADDRESS SHOULD BE MINIMUM 10 CHARACTERS...")
	private String customerAddress; // Represents the customer's address with validation constraints

	@NotNull // Specifies that the field must not be null
	private String customerPhone; // Represents the customer's phone number

	private boolean status = Boolean.TRUE; // Represents the status of the product, set to true by default

	List<OrderEntity> orders; // Represents the list of orders associated with the product
}
