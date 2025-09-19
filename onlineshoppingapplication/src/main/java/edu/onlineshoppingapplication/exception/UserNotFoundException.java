package edu.onlineshoppingapplication.exception;

public class UserNotFoundException extends RuntimeException {
	
	private String message = "User Not Found";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
