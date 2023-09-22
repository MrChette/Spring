package com.spring.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {
	
	//Implements methods over the users that will talk to the BBDD
	
	
	private static List<User> users = new ArrayList<User>();
	
	public static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"Nacho",new Date()));
		users.add(new User(++usersCount,"Javi",new Date()));
		users.add(new User(++usersCount,"Paco",new Date()));
	}
	
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
	}
	
	

}
