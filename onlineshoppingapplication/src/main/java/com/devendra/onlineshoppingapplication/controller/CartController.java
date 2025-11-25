package com.devendra.onlineshoppingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devendra.onlineshoppingapplication.entity.AddToCartRequest;
import com.devendra.onlineshoppingapplication.entity.Cart;
import com.devendra.onlineshoppingapplication.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    
    @Autowired
    private CartService cartService;

    // ✅ ADD ITEM TO CART
//    @PostMapping("/{userId}/add")
//    public ResponseEntity<Cart> addToCart(
//            @PathVariable Long userId,
//            @RequestParam Long productId,
//            @RequestParam int quantity) {
//
//        Cart cart = cartService.addToCart(userId, productId, quantity);
//        return ResponseEntity.ok(cart);
//    }
    
    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addToCart(
            @PathVariable Long userId,
            @RequestBody AddToCartRequest request) {

        Cart cart = cartService.addToCart(userId, request.productId, request.quantity);
        return ResponseEntity.ok(cart);
    }


    // ✅ UPDATE CART ITEM QUANTITY
    @PutMapping("/{userId}/update")
    public ResponseEntity<Cart> updateQuantity(
            @PathVariable Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity) {

        Cart cart = cartService.updateQuantity(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    // ❌ Wrong earlier: "/cats" + missing @RequestParam
    // ✅ REMOVE ITEM FROM CART
    @DeleteMapping("/{userId}/remove")
    public ResponseEntity<Cart> removeItem(
            @PathVariable Long userId,
            @RequestParam Long productId) {

        Cart cart = cartService.removeItem(userId, productId);
        return ResponseEntity.ok(cart);
    }

    // ❌ Missing @PathVariable
    // ✅ GET USER CART
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        Cart cart = cartService.getCart(userId);
        return ResponseEntity.ok(cart);
    }
}
