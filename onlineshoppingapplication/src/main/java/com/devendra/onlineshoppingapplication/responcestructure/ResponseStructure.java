package com.devendra.onlineshoppingapplication.responcestructure;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResponseStructure <T> {
	
	private String status;
	private LocalDate date;
	private int statusCode;
	
	private T obj;
	

}
