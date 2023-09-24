package com.spring.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.webservices.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
