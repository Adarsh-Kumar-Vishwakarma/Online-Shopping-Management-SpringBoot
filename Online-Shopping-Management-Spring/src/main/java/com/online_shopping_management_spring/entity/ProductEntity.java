package com.online_shopping_management_spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; // Defines the GenerationType for the ID
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor; // Lombok annotation for generating constructors
import lombok.Data; // Lombok annotation for generating getters, setters, and toString
import lombok.NoArgsConstructor; // Lombok annotation for generating a no-argument constructor

@Entity // Indicates that this class is an entity to be managed by JPA
@Data // Lombok annotation for generating getters, setters, and toString
@AllArgsConstructor // Lombok annotation to generate an all-argument constructor
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Table(name = "Product_Table") // Specifies the name of the database table

public class ProductEntity {
    @Id // Indicates that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the ID
    @Column(name = "product_id") // Specifies the column name in the database
    private int productId; // Represents the unique identifier for the product

    @Column(name = "product_name", length = 50) // Specifies the column name and its length
    private String productName; // Represents the name of the product

    @Column(name = "customer_address", length = 100) // Specifies the column name and its length
    private String customerAddress; // Represents the customer's address

    @Column(name = "customer_phone", length = 10, unique = true) // Specifies the column name, length, and uniqueness
    private String customerPhone; // Represents the customer's phone number

    private boolean status = Boolean.TRUE; // Represents the status of the product, set to true by default

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST) // Indicates a one-to-many relationship with OrderEntity
    @JsonIgnoreProperties("product") // Ignores the "product" property during JSON serialization
    List<OrderEntity> orders; // Represents the list of orders associated with the product
}
