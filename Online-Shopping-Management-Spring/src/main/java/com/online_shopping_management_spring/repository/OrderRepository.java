package com.online_shopping_management_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA repository interface

import com.online_shopping_management_spring.entity.OrderEntity; // Entity class for orders

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    // Extends JpaRepository for OrderEntity with an Integer as the primary key type
}
