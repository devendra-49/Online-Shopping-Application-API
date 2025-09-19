package com.devendra.onlineshoppingapplication.exception;

public class CategoryNotFoundException extends RuntimeException{

	private String message = "Category Not Found";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
