package com.devendra.onlineshoppingapplication.service;

import java.awt.print.Printable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devendra.onlineshoppingapplication.dao.UserDAO;
import com.devendra.onlineshoppingapplication.entity.User;
import com.devendra.onlineshoppingapplication.repository.UserJPARepository;
import com.devendra.onlineshoppingapplication.responcestructure.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDAO udao;
	
	public String addUser(User users) {
		return udao.addUser(users);
	}
	
	public List<User> findAll(){
		return udao.findAll();
	}
	
	public ResponseEntity<ResponseStructure<User>> findUsingId(int id) {
//		return udao.findUsingId(id);
		Optional<User> obj = udao.findUsingId(id);
		if(obj.isPresent()) {
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> findUsingName(String name){
//		return udao.findUsingName(name);
		Optional<User> obj = udao.findUsingName(name);
		if(obj.isPresent()) {
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUsingId(int id){
//		udao.deleteUsingId(id);
		Optional<User> obj = udao.findUsingId(id);
		if(obj.isPresent()) {
			udao.deleteUsingId(id);
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<User> responce = new ResponseStructure<User>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure"); 
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
//	public ResponseEntity<ResponseStructure<User>> updateUsingId(int id, User users){
//		    Optional<User> updatedUser = udao.findUsingId(id);
//		    if(updatedUser.isPresent()) {
//		    	udao.updateUsingId(id, users);
//				ResponseStructure<User> responce = new ResponseStructure<User>();
//		    	responce.setDate(LocalDate.now());
//				responce.setStatus("Success");
//				responce.setStatusCode(HttpStatus.FOUND.value());
//				responce.setObj(updatedUser.get());
//				return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.FOUND);
//		    }
//		    else {
//		    	ResponseStructure<User> responce = new ResponseStructure<User>();
//				responce.setDate(LocalDate.now());
//				responce.setStatus("Failure"); 
//				responce.setStatusCode(HttpStatus.NOT_FOUND.value());
//				responce.setObj(updatedUser.get());
//				return new ResponseEntity<ResponseStructure<User>>(responce, HttpStatus.NOT_FOUND);
//		    }
//	}	
	
	public ResponseEntity<ResponseStructure<User>> updateUsingId(int id, User users) {
	    ResponseStructure<User> response = new ResponseStructure<User>();
	    
	    try {
	        User updatedUser = udao.updateUsingId(id, users);
	        response.setDate(LocalDate.now());
	        response.setStatus("Success");
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setObj(updatedUser);
	        return new ResponseEntity<>(response, HttpStatus.OK);

	    } catch (RuntimeException e) {
	        response.setDate(LocalDate.now());
	        response.setStatus("Failure User not found with id "+ id);
	        response.setStatusCode(HttpStatus.NOT_FOUND.value());
	        response.setObj(null);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }
	}
	
}