package com.devendra.onlineshoppingapplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devendra.onlineshoppingapplication.dao.CategoryDAO;
import com.devendra.onlineshoppingapplication.entity.Category;
import com.devendra.onlineshoppingapplication.responcestructure.ResponseStructure;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO cdao;
	
	public String addCategory(Category category) {
		return cdao.addCategory(category);
	}
	
	public List<Category> findAll(){
		return cdao.findAll();
	}
	
	public ResponseEntity<ResponseStructure<Category>> findUsingId(long id){
//		return pdao.findUsingId(id);
		Optional<Category> obj = cdao.findUsingId(id);
		if(obj.isPresent()) {
			ResponseStructure<Category> responce = new ResponseStructure<Category>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Category>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<Category> responce = new ResponseStructure<Category>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Category>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Category>> findUsingName(String name){
		Optional<Category> obj = cdao.findUsingName(name);
		if(obj.isPresent()) {
			ResponseStructure<Category> responce = new ResponseStructure<Category>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Success");
			responce.setStatusCode(HttpStatus.FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Category>>(responce, HttpStatus.FOUND);
 		}
		else {
			ResponseStructure<Category> responce = new ResponseStructure<Category>();
			responce.setDate(LocalDate.now());
			responce.setStatus("Failure");
			responce.setStatusCode(HttpStatus.NOT_FOUND.value());
			responce.setObj(obj.get());
			return new ResponseEntity<ResponseStructure<Category>>(responce, HttpStatus.NOT_FOUND);
		}
	}
	
}
