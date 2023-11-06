package com.online_shopping_management_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA repository interface

import com.online_shopping_management_spring.entity.ProductEntity; // Entity class for products

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    // Extends JpaRepository for ProductEntity with an Integer as the primary key type
}
