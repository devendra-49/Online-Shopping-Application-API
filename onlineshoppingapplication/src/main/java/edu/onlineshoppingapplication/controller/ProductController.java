package edu.onlineshoppingapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.onlineshoppingapplication.entity.Product;
import edu.onlineshoppingapplication.responcestructure.ResponseStructure;
import edu.onlineshoppingapplication.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/products")
	public String addProduct(@RequestBody Product product) {
		return pservice.addProduct(product);
	}
	
	@GetMapping("/products")
	public List<Product> findAll(){
		return pservice.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> findUsingId(@PathVariable Long id){
		return pservice.findUsingId(id);
	}
	
	@GetMapping("/products/{name}")
	public ResponseEntity<ResponseStructure<Product>> findUsingName(@PathVariable String name){
		return pservice.findUsingName(name);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteUsingId(@PathVariable Long id){
		return pservice.deleteUsingId(id);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateUsingId(@PathVariable Long id, @RequestBody Product products){
		return pservice.updateUsingId(id, products);
	}
}
