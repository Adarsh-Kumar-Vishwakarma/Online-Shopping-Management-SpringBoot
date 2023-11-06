package com.online_shopping_management_spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Spring annotation for dependency injection
import org.springframework.stereotype.Service; // Indicates that this class is a service

import com.online_shopping_management_spring.entity.OrderEntity; // Import the OrderEntity class
import com.online_shopping_management_spring.entity.ProductEntity; // Import the ProductEntity class
import com.online_shopping_management_spring.exception.ResourceNotFoundException; // Custom exception for resource not found
import com.online_shopping_management_spring.model.OrderDTO; // Import the OrderDTO class
import com.online_shopping_management_spring.model.ProductDTO; // Import the ProductDTO class
import com.online_shopping_management_spring.repository.OrderRepository; // Import the OrderRepository
import com.online_shopping_management_spring.repository.ProductRepository; // Import the ProductRepository
import com.online_shopping_management_spring.service.ProductService; // Import the ProductService interface
import com.online_shopping_management_spring.utility.Converter; // Import the Converter utility

@Service // Indicates that this class is a service component

public class ProductImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository; // Autowired repository for products, with a consistent variable name

	@Autowired
	private OrderRepository orderRepository; // Autowired repository for orders, with a consistent variable name

	@Autowired
	private Converter converter; // Autowired Converter utility for entity-DTO conversion

	@Override
	public String assignOrderToProduct(int p_id, int o_id) {
	    // Retrieve the order entity by its ID or throw a resource not found exception
	    OrderEntity orderEntity = orderRepository.findById(o_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "o_id", o_id));

	    // Retrieve the product entity by its ID or throw a resource not found exception
	    ProductEntity productEntity = productRepository.findById(p_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product", "p_id", p_id));

	    // Add the order to the product's list of orders and set the product for the order
	    List<OrderEntity> orders = productEntity.getOrders();
	    orders.add(orderEntity);
	    productEntity.setOrders(orders);
	    orderEntity.setProduct(productEntity);

	    // Save the order and product entities
	    orderRepository.save(orderEntity);
	    productRepository.save(productEntity);

	    return "ORDER ASSIGNED TO THIS PRODUCT SUCCESSFULLY!";
	}


	@Override
	public ProductDTO registerProducts(ProductEntity productEntity) {
		// Save the product entity to the repository and convert the saved entity to a DTO
		ProductEntity savedProduct = productRepository.save(productEntity);
		return converter.convertToProductDTO(savedProduct);
	}


	@Override
	public ProductDTO updateProductById(int id, ProductEntity productEntity) {
		// Retrieve the existing product entity by its ID or return null
		ProductEntity existingProduct = productRepository.findById(id).orElse(null);
		
		if (existingProduct != null) {
			// Update the existing product with the provided data and save it
			existingProduct.setProductName(productEntity.getProductName());
			existingProduct.setCustomerAddress(productEntity.getCustomerAddress());
			existingProduct.setCustomerPhone(productEntity.getCustomerPhone());
			
			ProductEntity updatedProduct = productRepository.save(existingProduct);
			return converter.convertToProductDTO(updatedProduct);
		}else {
            throw new ResourceNotFoundException("Product", "id", id); // Throw a resource not found exception
        }
		
	}


	@Override
	public List<ProductDTO> getAllProduct() {
		// Retrieve all product entities, convert them to DTOs, and return a list of DTOs
		List<ProductEntity> productEntities = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for (ProductEntity productEntity : productEntities) {
			productDTOs.add(converter.convertToProductDTO(productEntity));
		}
		return productDTOs;
	}


	@Override
	public String deleteProductById(int id) {
		// Delete a product by its ID and return a confirmation message
		productRepository.deleteById(id);
		return "PRODUCT WITH ID " + id + " HAS BEEN DELETED SUCCESSFULLY.";
	}

	@Override
	public List<OrderDTO> getAllassignOrdertoProducts() {
	    // Retrieve all products and their associated orders, and convert orders to OrderDTOs
	    List<ProductEntity> products = productRepository.findAll();
	    List<OrderDTO> allOrders = new ArrayList<>();

	    for (ProductEntity product : products) {
	        List<OrderEntity> orders = product.getOrders();

	        for (OrderEntity order : orders) {
	            allOrders.add(converter.convertToOrderDTO(order));
	        }
	    }

	    return allOrders;
	}
}
