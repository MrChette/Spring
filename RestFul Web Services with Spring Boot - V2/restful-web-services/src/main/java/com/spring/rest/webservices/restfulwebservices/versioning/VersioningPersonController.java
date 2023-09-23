package com.spring.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirtsVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirtsVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirtsVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirtsVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

}
