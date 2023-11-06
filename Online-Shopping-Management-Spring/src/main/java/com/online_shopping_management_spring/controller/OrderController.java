package com.online_shopping_management_spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_shopping_management_spring.entity.OrderEntity;
import com.online_shopping_management_spring.model.OrderDTO;
import com.online_shopping_management_spring.service.OrderService;
import com.online_shopping_management_spring.utility.Converter;

@RestController //Annotation indicating that this class is a Spring REST Controller
@RequestMapping("/api") //Request mapping to define the base URL for this controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Converter converter;

	// Create a new order
	@PostMapping("/createOrder") // Using a descriptive path
	ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
		final OrderEntity orderEntity = converter.convertToOrderEntity(orderDTO);
		return new ResponseEntity<OrderDTO>(orderService.createOrder(orderEntity), HttpStatus.CREATED);
	}

	// Create multiple orders
	@PostMapping("/createMultipleOrder")
	ResponseEntity<List<OrderDTO>> createMultipleOrder(@Valid @RequestBody List<OrderEntity> orderEntities) {
		final List<OrderDTO> createdOrders = orderService.createMultipleOrder(orderEntities);
		return new ResponseEntity<>(createdOrders, HttpStatus.CREATED);
	}

	// Get all orders
	@GetMapping("/getAllOrders")
	List<OrderDTO> getAllOrders() {
		return orderService.getAllOrders();
	}

	// Get an order by its ID
	@GetMapping("/getOrderById/{orderId}")
	OrderDTO getOrderById(@PathVariable("orderId") int id) {
		return orderService.getOrderById(id);
	}

	// Update an order by its ID
	@PutMapping("/updateOrderById/{orderId}")
	OrderDTO updateOrderById(@Valid @PathVariable("orderId") int id, @RequestBody OrderDTO orderDTO) {
		final OrderEntity orderEntity = converter.convertToOrderEntity(orderDTO);
		return orderService.updateOrderById(id, orderEntity);
	}

	// Delete an order by its ID
	@DeleteMapping("/deleteOrderById/{orderId}")
	String deleteOrderById(@PathVariable("orderId") int id) {
		return orderService.deleteOrderById(id);
	}
}
