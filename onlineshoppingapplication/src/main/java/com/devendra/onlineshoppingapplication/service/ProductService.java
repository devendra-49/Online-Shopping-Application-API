package com.devendra.onlineshoppingapplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.ProductDAO;
import com.devendra.onlineshoppingapplication.entity.Product;
import com.devendra.onlineshoppingapplication.entity.User;
import com.devendra.onlineshoppingapplication.responcestructure.ResponseStructure;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO pdao;
	
	public String addProduct(Product product) {
		return pdao.addProduct(product);
	}
	
	public List<Product> findAll(){
		return pdao.findAll();
	}
	
	public ResponseEntity<ResponseStructure<Product>> findUsingId(Long id){
//		return pdao.findUsingId(id);
		Optional<Product> obj = pdao.findUsingId(id);
		if(obj.isPresent()) {
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> findUsingName(String name){
//		return udao.findUsingName(name);
		Optional<Product> obj = pdao.findUsingName(name);
		if(obj.isPresent()) {
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteUsingId(Long id){
//		udao.deleteUsingId(id);
		Optional<Product> obj = pdao.findUsingId(id);
		if(obj.isPresent()) {
			pdao.deleteUsingId(id);
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<Product> responce = new ResponseStructure<Product>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure"); 
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Product>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateUsingId(Long id, Product products) {
	    ResponseStructure<Product> response = new ResponseStructure<Product>();
	    
	    try {
	        Product updatedProduct = pdao.updateUsingId(id, products);
	        response.setDate(LocalDate.now());
	        response.setStatus("Success");
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setObj(updatedProduct);
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
