package edu.onlineshoppingapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.onlineshoppingapplication.entity.Category;
import edu.onlineshoppingapplication.entity.Product;
import edu.onlineshoppingapplication.exception.CategoryNotFoundException;
import edu.onlineshoppingapplication.exception.NoDataExist;
import edu.onlineshoppingapplication.exception.UserNotFoundException;
import edu.onlineshoppingapplication.repository.CategoryJPARepository;

@Repository
public class CategoryDAO {
	
	@Autowired
	private CategoryJPARepository cjpa;
	
	public String addCategory(Category category) {
		cjpa.save(category);
		return "Category Added...";
	}
	
	public List<Category> findAll(){
		List<Category> li = cjpa.findAll();
		if (li.isEmpty()) {
			throw new NoDataExist();
		}
		return li;
	}
	
	public Optional<Category> findUsingId(Long id){
		Optional<Category> obj = cjpa.findById(id);
		if (obj.isPresent()) {
			return obj;
		}
		else {
			throw new CategoryNotFoundException();
		}
	}
	
	public Optional<Category> findUsingName(String name){
//		return cjpa.findByName(name);
		Optional<Category> obj = cjpa.findByName(name);
		if(obj.isPresent()) {
			return obj;
		}
		else {
			throw new CategoryNotFoundException();
		}
	}
	
}
