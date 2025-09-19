package edu.devendra.onlineshoppingapplication.exception;

public class NoDataExist extends RuntimeException {
	
	private String message = "No Data Found";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}	
}
