package com.online_shopping_management_spring.service;

import java.util.List;

import com.online_shopping_management_spring.entity.OrderEntity; // Import the OrderEntity class
import com.online_shopping_management_spring.model.OrderDTO; // Import the OrderDTO class

public interface OrderService {

    // Create a single order and return an OrderDTO
    OrderDTO createOrder(OrderEntity orderEntity);

    // Create multiple orders and return a list of OrderDTOs
    List<OrderDTO> createMultipleOrder(List<OrderEntity> orderEntities);

    // Retrieve all orders and return a list of OrderDTOs
    List<OrderDTO> getAllOrders();

    // Retrieve a specific order by its ID and return an OrderDTO
    OrderDTO getOrderById(int id);

    // Update a specific order by its ID with the provided OrderEntity and return an OrderDTO
    OrderDTO updateOrderById(int id, OrderEntity orderEntity);

    // Delete a specific order by its ID and return a confirmation message
    String deleteOrderById(int id);
}
