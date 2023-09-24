package com.spring.rest.webservices.restfulwebservices.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.rest.webservices.restfulwebservices.user.User;
import com.spring.rest.webservices.restfulwebservices.user.UserDaoService;
import com.spring.rest.webservices.restfulwebservices.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {
	
	private UserDaoService userDaoService;
	
	private UserRepository userRepository ;
	
	public UserJpaResource(UserDaoService service,UserRepository repository) {
		this.userDaoService = service;
		this.userRepository = repository;
	}
	
	//GET /user
	@GetMapping("/users")
	public List<User> retrieveAllUser(){
		return userRepository.findAll();
	}
	
	//GET /user/{id}
	
	// return to /users
		//entitymodel
		//webmMvcLinkBuilder
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get()); 
		
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
		userRepository.deleteById(id);
	}
	
	//POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri() ;
		return ResponseEntity.created(location ).build();
	}
	

}
