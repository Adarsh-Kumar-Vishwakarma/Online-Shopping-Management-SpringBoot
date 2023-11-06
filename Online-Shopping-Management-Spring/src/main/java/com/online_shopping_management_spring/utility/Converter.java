package com.online_shopping_management_spring.utility;

import org.springframework.beans.BeanUtils; // Spring utility for copying properties between objects
import org.springframework.stereotype.Component; // Indicates that this class is a Spring component

import com.online_shopping_management_spring.entity.OrderEntity; // Import the OrderEntity class
import com.online_shopping_management_spring.entity.ProductEntity; // Import the ProductEntity class
import com.online_shopping_management_spring.model.OrderDTO; // Import the OrderDTO class
import com.online_shopping_management_spring.model.ProductDTO; // Import the ProductDTO class

@Component // Indicates that this class is a Spring component

public class Converter {
    // Convert from DTO to Entity for orders
    public OrderEntity convertToOrderEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        if (orderDTO != null) {
            BeanUtils.copyProperties(orderDTO, orderEntity);
        }
        return orderEntity;
    }

    // Convert from Entity to DTO for orders
    public OrderDTO convertToOrderDTO(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        if (orderEntity != null) {
            BeanUtils.copyProperties(orderEntity, orderDTO);
        }
        return orderDTO;
    }

    // Convert from DTO to Entity for products
    public ProductEntity convertToProductEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        if (productDTO != null) {
            BeanUtils.copyProperties(productDTO, productEntity);
        }
        return productEntity;
    }

    // Convert from Entity to DTO for products
    public ProductDTO convertToProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        if (productEntity != null) {
            BeanUtils.copyProperties(productEntity, productDTO);
        }
        return productDTO;
    }
}
