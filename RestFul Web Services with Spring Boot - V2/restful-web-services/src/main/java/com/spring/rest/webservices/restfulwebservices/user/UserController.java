package com.spring.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService userDaoService;
	
	public UserController(UserDaoService service) {
		this.userDaoService = service;
	}
	
	//GET /user
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return userDaoService.findAll();
	}
	
	//GET /user/{id}
	
	// return to /users
		//entitymodel
		//webmMvcLinkBuilder
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = userDaoService.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user); 
		
		//add Links to the entityModel ( retrieveAllUser of this class in this case)
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
		
		
		entityModel.add(link.withRel("all-users"));
		//this add retrieve this info
		/*
		 "_links": {
			"all-users": {
				"href": "http://localhost:8080/users"
				}
			}
		 */
		
		return entityModel;
	}
	
	//DELETE /user/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		userDaoService.deleteById(id);
	}
	
	//POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri() ;
		return ResponseEntity.created(location ).build();
	}
	

}
