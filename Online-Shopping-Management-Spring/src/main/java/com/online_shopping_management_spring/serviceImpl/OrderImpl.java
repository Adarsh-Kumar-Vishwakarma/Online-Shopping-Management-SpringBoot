package com.online_shopping_management_spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Spring annotation for dependency injection
import org.springframework.stereotype.Service; // Indicates that this class is a service

import com.online_shopping_management_spring.entity.OrderEntity; // Import the OrderEntity class
import com.online_shopping_management_spring.exception.ResourceNotFoundException; // Custom exception for resource not found
import com.online_shopping_management_spring.model.OrderDTO; // Import the OrderDTO class
import com.online_shopping_management_spring.repository.OrderRepository; // Import the OrderRepository
import com.online_shopping_management_spring.service.OrderService; // Import the OrderService interface
import com.online_shopping_management_spring.utility.Converter; // Import the Converter utility

@Service // Indicates that this class is a service component

public class OrderImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository; // Autowired repository for orders, with a consistent variable name

    @Autowired
    private Converter converter; // Autowired Converter utility for entity-DTO conversion

    @Override
    public OrderDTO createOrder(OrderEntity orderEntity) {
        // Save the order entity to the repository and convert the saved entity to DTO
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return converter.convertToOrderDTO(savedOrder);
    }
    
    @Override
    public List<OrderDTO> createMultipleOrder(List<OrderEntity> orderEntity) {
        // Save multiple order entities, convert them to DTOs, and return a list of DTOs
        Iterable<OrderEntity> savedOrderEntities = orderRepository.saveAll(orderEntity);
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (OrderEntity entity : savedOrderEntities) {
            OrderDTO orderDTO = converter.convertToOrderDTO(entity);
            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        // Retrieve all order entities, convert them to DTOs, and return a list of DTOs
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntities) {
            orderDTOs.add(converter.convertToOrderDTO(orderEntity));
        }

        return orderDTOs;
    }

    @Override
    public OrderDTO getOrderById(int id) {
        // Retrieve an order entity by its ID, convert it to a DTO, or throw a resource not found exception
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return converter.convertToOrderDTO(orderEntity);
    }

    @Override
    public OrderDTO updateOrderById(int id, OrderEntity orderEntity) {
        // Update an order by its ID, or throw a resource not found exception if it doesn't exist
        OrderEntity existingOrder = orderRepository.findById(id).orElse(null);
        
        if (existingOrder != null) {
            existingOrder.setOrderName(orderEntity.getOrderName());
            existingOrder.setOrderPrice(orderEntity.getOrderPrice());
            existingOrder.setOrderQuantity(orderEntity.getOrderQuantity());
            
            OrderEntity updatedOrder = orderRepository.save(existingOrder);
            return converter.convertToOrderDTO(updatedOrder);
        } else {
            throw new ResourceNotFoundException("Order", "id", id);
        }
    }

    @Override
    public String deleteOrderById(int id) {
        // Delete an order by its ID and return a confirmation message
        orderRepository.deleteById(id);
        return "ORDER WITH ID " + id + " HAS BEEN DELETED SUCCESSFULLY.";
    }
}
