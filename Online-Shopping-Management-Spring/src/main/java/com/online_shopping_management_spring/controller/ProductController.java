package com.online_shopping_management_spring.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online_shopping_management_spring.entity.ProductEntity;
import com.online_shopping_management_spring.model.OrderDTO;
import com.online_shopping_management_spring.model.ProductDTO;
import com.online_shopping_management_spring.service.ProductService;
import com.online_shopping_management_spring.utility.Converter;

@RestController //Annotation indicating that this class is a Spring REST Controller
@RequestMapping("/api") //Request mapping to define the base URL for this controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Converter converter;

    // Create a new product
    @PostMapping("/createProduct")
    ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        final ProductEntity productEntity = converter.convertToProductEntity(productDTO);
        return new ResponseEntity<>(productService.registerProducts(productEntity), HttpStatus.CREATED);
    }

    // Assign an order to a product using path variables
    @PostMapping("/assignOrderToProduct/{p_id}/{o_id}")
    public String assignOrderToProduct(@PathVariable("p_id") int p_id, @PathVariable("o_id") int o_id) {
        return productService.assignOrderToProduct(p_id, o_id);
    }

    // Get all products
    @GetMapping("/getAllProduct")
    List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    // Update a product by its ID
    @PutMapping("/updateProductById/{productId}")
    ProductDTO updateProductById(@Valid @PathVariable("productId") int id, @RequestBody ProductDTO productDTO) {
        final ProductEntity productEntity = converter.convertToProductEntity(productDTO);
        return productService.updateProductById(id, productEntity);
    }

    // Delete a product by its ID
    @DeleteMapping("/deleteProductById/{productId}")
    String deleteProductById(@PathVariable("productId") int id) {
        return productService.deleteProductById(id);
    }

    // Get all orders assigned to products
    @GetMapping("/getAllassignOrdertoProducts")
    List<OrderDTO> getAllassignOrdertoProducts() {
        List<OrderDTO> allOrders = productService.getAllassignOrdertoProducts();
        return allOrders;
    }
    
    /*@PostMapping("/assignOrderToProduct")
    public String assignOrderToProduct(
            @RequestParam("productId") int productId,
            @RequestParam("orderId") int orderId
    ) {
        return productService.assignOrderToProduct(productId, orderId);
    }*/
}
