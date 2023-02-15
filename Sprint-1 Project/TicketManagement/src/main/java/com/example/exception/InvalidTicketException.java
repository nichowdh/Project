package com.example.exception;

//custom exception
public class InvalidTicketException extends Exception {

	public InvalidTicketException(String message) {
		super(message);
	}

}
