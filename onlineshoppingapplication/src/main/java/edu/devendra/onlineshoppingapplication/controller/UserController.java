package edu.devendra.onlineshoppingapplication.controller;

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

import edu.devendra.onlineshoppingapplication.entity.User;
import edu.devendra.onlineshoppingapplication.repository.UserJPARepository;
import edu.devendra.onlineshoppingapplication.responcestructure.ResponseStructure;
import edu.devendra.onlineshoppingapplication.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService uservice;
		
	@PostMapping("/users")
	public String addUser(@RequestBody User users) {
		return uservice.addUser(users);
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return uservice.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUsingId(@PathVariable int id) {
		return uservice.findUsingId(id);
	}
	
	@GetMapping("/users/name/{name}") 
	public ResponseEntity<ResponseStructure<User>> findUsingName(@PathVariable String name){
		return uservice.findUsingName(name);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUsingId(@PathVariable int id){
		return uservice.deleteUsingId(id);
	}
	
//	@PutMapping("/users/{id}")
//	public ResponseEntity<ResponseStructure<User>> updateUsingId(@PathVariable int id, @RequestBody User users){
//		return uservice.updateUsingId(id, users);
//	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUsingId(@PathVariable int id, @RequestBody User users) {
	    return uservice.updateUsingId(id, users);
	}

	
	
}
