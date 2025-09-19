package edu.devendra.onlineshoppingapplication.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String catchUserNotFoundException(UserNotFoundException exe) {
		return exe.getMessage();
	}
	
	@ExceptionHandler(NoDataExist.class)
	public String catchNoDataExistException(NoDataExist exe) {
		return exe.getMessage();
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String catchProductNotFoundException(ProductNotFoundException exe) {
		return exe.getMessage();
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public String catchCategoryNotFoundException(CategoryNotFoundException exe) {
		return exe.getMessage();
	}
	
}
