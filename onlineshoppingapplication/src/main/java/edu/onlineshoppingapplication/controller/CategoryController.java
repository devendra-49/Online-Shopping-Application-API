package edu.onlineshoppingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.onlineshoppingapplication.entity.Category;
import edu.onlineshoppingapplication.entity.Product;
import edu.onlineshoppingapplication.responcestructure.ResponseStructure;
import edu.onlineshoppingapplication.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService cservice;
	
	@PostMapping("/categorys")
	public String addCategory(@RequestBody Category category) {
		return cservice.addCategory(category);
	}
	
	@GetMapping("/categorys")
	public List<Category> findAll(){
		return cservice.findAll();
	} 
	
	@GetMapping("/categorys/id/{id}")
	public ResponseEntity<ResponseStructure<Category>> findUsingId(@PathVariable Long id){
		return cservice.findUsingId(id);
	}
	
	@GetMapping("/categorys/{name}")
	public ResponseEntity<ResponseStructure<Category>> findUsingName(@PathVariable String name){
		return cservice.findUsingName(name);
	}
}
