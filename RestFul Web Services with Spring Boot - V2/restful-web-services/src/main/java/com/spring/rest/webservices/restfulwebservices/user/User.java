package com.spring.rest.webservices.restfulwebservices.user;

import java.util.Date;

import jakarta.persistence.GeneratedValue;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	@GeneratedValue
	private Integer id;
	
	
	@Size(min=2, message = "Name should have at least 2 characters")
	private String name;
	
	@Past(message = "BirthDate should be in the past")
	private Date birthDate;
	

	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birhDate=" + birthDate + "]";
	}
	
	
	
	

}
