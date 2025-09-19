package edu.onlineshoppingapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.onlineshoppingapplication.dao.CartDAO;
import edu.onlineshoppingapplication.entity.Cart;
import edu.onlineshoppingapplication.entity.CartItem;
import edu.onlineshoppingapplication.entity.Product;
import edu.onlineshoppingapplication.entity.User;
import edu.onlineshoppingapplication.repository.ProductJPARepository;

@Service
public class CartService {
	
	@Autowired
	private CartDAO cartdao;
	
	@Autowired
	private ProductJPARepository productjpa;
	
//	public Cart addCart(Long userId, Long productId, int quantity){
//			return cartdao.addCart(cart);
//		Cart cart = cartdao.findByUserId(userId);
//		if (cart == null) {
//			cart = new Cart();
//			User user = new User();
//			user.setId(userId);
//			cart.setUser(user);	
//		}
//	}
	
	public Cart addToCart(Long userId, Long productId, int quantity){
		 return cartdao.addToCart(userId, productId, quantity);
	}
	
	public Cart updateQuantity(Long userId, Long productId, int quantity) {
		return cartdao.updateQuantity(userId, productId, quantity);
	}
	
    public Cart removeItem(Long userId, Long productId) {
    	return cartdao.removeItem(userId, productId);
    }
    
    public Cart getCart(Long userId) {
    	return cartdao.getCart(userId);
    }
	
}
