package com.online_shopping_management_spring.service;

import java.util.List;

import com.online_shopping_management_spring.entity.ProductEntity; // Import the ProductEntity class
import com.online_shopping_management_spring.model.OrderDTO; // Import the OrderDTO class
import com.online_shopping_management_spring.model.ProductDTO; // Import the ProductDTO class

public interface ProductService {

    // Assign an order to a product by their IDs and return a status message
    String assignOrderToProduct(int productId, int orderId);

    // Register a new product and return a ProductDTO
    ProductDTO registerProducts(ProductEntity productEntity);

    // Update a specific product by its ID with the provided ProductEntity and return a ProductDTO
    ProductDTO updateProductById(int id, ProductEntity productEntity);

    // Retrieve all products and return a list of ProductDTOs
    List<ProductDTO> getAllProduct();

    // Retrieve all orders assigned to products and return a list of OrderDTOs
    List<OrderDTO> getAllassignOrdertoProducts();

    // Delete a specific product by its ID and return a confirmation message
    String deleteProductById(int id);
}
