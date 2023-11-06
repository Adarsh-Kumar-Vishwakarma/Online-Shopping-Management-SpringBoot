package com.online_shopping_management_spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; // Defines the GenerationType for the ID
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor; // Lombok annotation for generating constructors
import lombok.Data; // Lombok annotation for generating getters, setters, and toString
import lombok.NoArgsConstructor; // Lombok annotation for generating a no-argument constructor

@Entity // Indicates that this class is an entity to be managed by JPA
@Data // Lombok annotation for generating getters, setters, and toString
@AllArgsConstructor // Lombok annotation to generate an all-argument constructor
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@Table(name = "Order_Table") // Specifies the name of the database table

public class OrderEntity {
    @Id // Indicates that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the ID
    @Column(name = "order_id") // Specifies the column name in the database
    private int orderId; // Represents the unique identifier for the order

    @Column(name = "order_name", length = 40) // Specifies the column name and its length
    private String orderName; // Represents the name of the order

    @Column(name = "order_quantity") // Specifies the column name
    private String orderQuantity; // Represents the quantity of the order

    @Column(name = "order_price") // Specifies the column name
    private String orderPrice; // Represents the price of the order

    private boolean status = Boolean.TRUE; // Represents the status of the order, set to true by default

    @ManyToOne(cascade = CascadeType.PERSIST) // Indicates a many-to-one relationship with ProductEntity
    @JoinColumn(name = "product_id") // Specifies the foreign key column name in the database
    @JsonIgnoreProperties("orders") // Ignores the "orders" property during JSON serialization
    private ProductEntity product; // Represents the associated product for the order
}
