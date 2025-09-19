package com.devendra.onlineshoppingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.onlineshoppingapplication.entity.Cart;
import com.devendra.onlineshoppingapplication.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
//	@PostMapping("/carts")
//	public Cart addToCart(@RequestBody Cart cart) {
//		return cartservice.addCart(cart);
//	}
	
	 @PostMapping("carts/{userId}/add")
	 public ResponseEntity<Cart> addToCart(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity) {
	       Cart cart = cartservice.addToCart(userId, productId, quantity);
	       return ResponseEntity.ok(cart);
    }
	 
//		public Cart addToCart(Long userId, Long productId, int quantity){
//			 return cartservice.addToCart(userId, productId, quantity);
//		}
	 
	 	@PutMapping("/carts/{userId}")
		public Cart updateQuantity(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quantity) {
			return cartservice.updateQuantity(userId, productId, quantity);
		}
		
	 	@DeleteMapping("/cats/{userId}")
	    public Cart removeItem(Long userId, Long productId) {
	    	return cartservice.removeItem(userId, productId);
	    }
	    
	 	@GetMapping("/carts/{userId}")
	    public Cart getCart(Long userId) {
	    	return cartservice.getCart(userId);
	    } 
}
