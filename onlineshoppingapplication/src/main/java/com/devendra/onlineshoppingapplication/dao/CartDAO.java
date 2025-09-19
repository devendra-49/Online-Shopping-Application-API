package com.devendra.onlineshoppingapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendra.onlineshoppingapplication.entity.Cart;
import com.devendra.onlineshoppingapplication.entity.CartItem;
import com.devendra.onlineshoppingapplication.entity.Product;
import com.devendra.onlineshoppingapplication.entity.User;
import com.devendra.onlineshoppingapplication.repository.CartJPARepository;
import com.devendra.onlineshoppingapplication.repository.ProductJPARepository;

@Repository
public class CartDAO {
	
	@Autowired
	private CartJPARepository cartjpa;
	
	@Autowired
	private ProductJPARepository productjpa;
	
//	public String addCart(Cart carts) {
//		cartjpa.save(carts);
//		return "Cart Added";
//	}
	
//	public Cart findByUserId(Long userId) {
////		return cartjpa.findById(userId);
//		return cartjpa.findByUserId(userId);
//	}
	
	 public Cart addToCart(Long userId, Long productId, int quantity) {
	        Cart cart = cartjpa.findByUserId(userId);
	        if (cart == null) {
	            cart = new Cart();
	            User user = new User();
	            user.setId(userId);
	            cart.setUser(user);
	            cart = cartjpa.save(cart);
	        }

	        Product product = productjpa.findById(productId).orElse(null);
	        if (product == null) {
	            throw new RuntimeException("Product not found");
	        }

	        CartItem existingItem = null;
	        for (CartItem item : cart.getItems()) {
	            if (item.getProduct().getId().equals(productId)) {
	                existingItem = item;
	                break;
	            }
	        }

	        if (existingItem != null) {
	            existingItem.setQuantity(existingItem.getQuantity() + quantity);
	            existingItem.setPrice(existingItem.getQuantity() * product.getPrice());
	        } else {
	            CartItem newItem = new CartItem();
	            newItem.setProduct(product);
	            newItem.setQuantity(quantity);
	            newItem.setPrice(product.getPrice() * quantity);
	            newItem.setCart(cart);
	            cart.getItems().add(newItem);
	        }

	        updateTotal(cart);
	        return cartjpa.save(cart);
	    }

	    public Cart updateQuantity(Long userId, Long productId, int quantity) {
	        Cart cart = cartjpa.findByUserId(userId);
	        if (cart == null) {
	            throw new RuntimeException("Cart not found");
	        }

	        CartItem foundItem = null;
	        for (CartItem item : cart.getItems()) {
	            if (item.getProduct().getId().equals(productId)) {
	                foundItem = item;
	                break;
	            }
	        }

	        if (foundItem == null) {
	            throw new RuntimeException("Product not in cart");
	        }

	        foundItem.setQuantity(quantity);
	        foundItem.setPrice(foundItem.getProduct().getPrice() * quantity);

	        updateTotal(cart);
	        return cartjpa.save(cart);
	    }

	    public Cart removeItem(Long userId, Long productId) {
	        Cart cart = cartjpa.findByUserId(userId);
	        if (cart == null) {
	            throw new RuntimeException("Cart not found");
	        }

	        CartItem toRemove = null;
	        for (CartItem item : cart.getItems()) {
	            if (item.getProduct().getId().equals(productId)) {
	                toRemove = item;
	                break;
	            }
	        }

	        if (toRemove != null) {
	            cart.getItems().remove(toRemove);
	        }

	        updateTotal(cart);
	        return cartjpa.save(cart);
	    }

	    public Cart getCart(Long userId) {
	        Cart cart = cartjpa.findByUserId(userId);
	        if (cart == null) {
	            throw new RuntimeException("Cart not found");
	        }
	        return cart;
	    }

	    private void updateTotal(Cart cart) {
	        double total = 0.0;
	        for (CartItem item : cart.getItems()) {
	            total += item.getPrice();
	        }
	        cart.setTotalPrice(total);
	    }    
}
