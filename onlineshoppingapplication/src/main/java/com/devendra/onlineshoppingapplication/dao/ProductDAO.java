package com.devendra.onlineshoppingapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendra.onlineshoppingapplication.entity.Product;
import com.devendra.onlineshoppingapplication.exception.NoDataExist;
import com.devendra.onlineshoppingapplication.exception.ProductNotFoundException;
import com.devendra.onlineshoppingapplication.exception.UserNotFoundException;
import com.devendra.onlineshoppingapplication.repository.ProductJPARepository;

@Repository
public class ProductDAO {

	@Autowired
	private ProductJPARepository pjpa;
	
	public String addProduct(Product product) {
		pjpa.save(product);
		return "Product Added...";
	}
	
	public List<Product> findAll(){
		List<Product> li = pjpa.findAll();
		if(li.isEmpty()) {
			throw new NoDataExist();
		}
		return li;
	}
	
	public Optional<Product> findUsingId(Long id) {
		 Optional<Product> obj = pjpa.findById(id);
		 if(obj.isPresent()) {
			return obj;
		 }
		 else {
			 throw new ProductNotFoundException();
		 }
	}
	
	public Optional<Product> findUsingName(String name){
//		return pjpa.findByName(name);
		Optional<Product> obj = pjpa.findByName(name);
		if (obj.isPresent()) {
			return obj;
		}
		else {
			throw new ProductNotFoundException();
		}
	}
	
	public void deleteUsingId(Long id){
		 pjpa.deleteById(id);
	}
	
	
	public Product updateUsingId(Long id, Product products) {
	    Optional<Product> optionalProduct = pjpa.findById(id);

	    if (optionalProduct.isPresent()) {
	        Product existingProduct = optionalProduct.get();

	        if (products.getName() != null && !products.getName().isEmpty()) {
	            existingProduct.setName(products.getName());
	        }               
	        else if (products.getPrice() != 0) {
	            existingProduct.setPrice(products.getPrice());
	        }
	        else if (products.getStock() != 0 && products.getStock() == 0 ) {
	            existingProduct.setStock(products.getStock());
	        }
	        return pjpa.save(existingProduct);
	    }
	    else {
	        throw new RuntimeException("Product not found with id " + id);
	    }
	}
}
