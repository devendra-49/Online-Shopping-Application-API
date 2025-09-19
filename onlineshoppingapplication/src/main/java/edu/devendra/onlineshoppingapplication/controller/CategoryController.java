package edu.devendra.onlineshoppingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.devendra.onlineshoppingapplication.entity.Category;
import edu.devendra.onlineshoppingapplication.entity.Product;
import edu.devendra.onlineshoppingapplication.responcestructure.ResponseStructure;
import edu.devendra.onlineshoppingapplication.service.CategoryService;

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
