package com.evnt.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Product;
import com.evnt.exception.ResourceNotFoundException;
import com.evnt.repo.ProductRepo;
import com.evnt.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductRepo prorp;
	
	@Autowired
	private ProductService proSer;
	
	@GetMapping(value="/product", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProduct() {
		return proSer.findAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		Product product = prorp.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping("/product")
	public Product createEmployee(@Valid @RequestBody Product product) {
		return prorp.save(product);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = prorp.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		product.setAccUser(productDetails.getAccUser());
		product.setAccPass(productDetails.getAccPass());
		final Product updatedProduct = prorp.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/product/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		Product product = prorp.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		prorp.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
