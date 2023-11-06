package com.online_shopping_management_spring.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.online_shopping_management_spring.entity.ProductEntity;

import lombok.Getter; // Lombok annotation for generating getter methods
import lombok.Setter; // Lombok annotation for generating setter methods

@Getter // Lombok annotation for generating getter methods
@Setter // Lombok annotation for generating setter methods

public class OrderDTO {
    @NotNull // Specifies that the field must not be null
    private int orderId; // Represents the unique identifier for the order

    @NotNull // Specifies that the field must not be null
    @Size(min = 2, max = 40, message = "YOUR ORDER NAME SHOULD BE MINIMUM 2 AND MAXIMUM 40 CHARACTERS...")
    //@Min(value = 2, message = "YOUR ORDER NAME SHOULD BE MINIMUM 2 CHARACTERS...")
    //@Max(value = 40, message = "YOUR ORDER NAME SHOULD BE MAXIMUM 40 CHARACTERS...")
    private String orderName; // Represents the name of the order with validation constraints

    @NotNull // Specifies that the field must not be null
    //@Size(min = 1, max = 10, message = "QUANTITY MUST BE AT LEAST 1 AND QUANTITY CANNOT EXCEED 10")
    @Min(value = 1, message = "QUANTITY MUST BE AT LEAST 1")
    @Max(value = 10, message = "QUANTITY CANNOT EXCEED 10")
    private String orderQuantity; // Represents the quantity of the order with validation constraints

    @NotNull // Specifies that the field must not be null
    private String orderPrice; // Represents the price of the order

    private boolean status = Boolean.TRUE; // Represents the status of the order, set to true by default

    private ProductEntity product; // Represents the associated product for the order (type should be changed to ProductDTO)
}
