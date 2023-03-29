package com.project.Cargo.Courier.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Cargo.Courier.management.system.entity.Product;
import com.project.Cargo.Courier.management.system.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductRepository pr;

	// Get all product
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return pr.findAll();
	}

	// create product
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return pr.save(product);
	}

	// update product
	@PutMapping("/product/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
		Product _product = pr.findById(productId).get();
		_product.setProductName(product.getProductName());
		_product.setProductWeight(product.getProductWeight());
		_product.setProductWeight(product.getProductWeight());
		_product.setProductDescription(product.getProductDescription());
		return pr.save(_product);
	}

	// delete product
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		pr.deleteById(productId);
		return "Product is deleted";
	}

}
