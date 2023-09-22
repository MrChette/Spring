package com.spring.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timpestam;
	private String message;
	private String details;
	
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timpestam = localDateTime;
		this.message = message;
		this.details = details;
	}


	public LocalDateTime getTimpestam() {
		return timpestam;
	}


	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
