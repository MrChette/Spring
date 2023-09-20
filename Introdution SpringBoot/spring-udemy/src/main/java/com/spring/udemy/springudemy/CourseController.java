package com.spring.udemy.springudemy;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// /courses

// Course: id,name, author

@RestController
public class CourseController {
	
	
	// /courses
	

	// Course: id,name, author
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Amazon", "Udemy"),
				new Course(2, "FaceBook", "Udemy"),
				new Course(3, "Twitter", "Udemy")
				);
	}
	

}
