package com.devendra.onlineshoppingapplication.exception;

public class ProductNotFoundException extends RuntimeException {

	private String message = "Product Not Found";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
