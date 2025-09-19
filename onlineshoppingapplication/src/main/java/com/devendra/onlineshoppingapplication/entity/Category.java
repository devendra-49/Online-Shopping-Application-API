package com.devendra.onlineshoppingapplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categorys")
public class Category {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name;
	
    // One Category can have many Products
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;
}	
