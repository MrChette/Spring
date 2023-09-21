package programming;

import java.util.List;

public class FP02FunctionalExercises {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "Api", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

			// First exercise , print all courses individually
		//printAllcoursesIndividualy(courses);


			// Second excercise, print all coruses that contains the word spring
		//printAllCoursesFilterByWord(courses, "Spring");


			// Third exercise, print all course with at least 4 lettes
		//printAllCoursesByLength(courses, 4);
		
			//Print the cubes of odd numbers
		//printCubesOfOddNumbers(numbers);
		
			//Print the numbers of characters in each course name
		printNumOfCharInCourse(courses);

	}

	private static void printAllcoursesIndividualy(List<String> courses) {

		courses.stream()
			.forEach(System.out::println);

	}

	private static void printAllCoursesFilterByWord(List<String> courses, String course) {

		courses.stream()
			.filter(c -> c.contains(course))
			.forEach(System.out::println);

	}

	private static void printAllCoursesByLength(List<String> courses, int number) {

		courses
			.stream()
			.filter(c -> c.length() > number)
			.forEach(System.out::println);
	}
	
	private static void printCubesOfOddNumbers(List<Integer> numbers) {
		
		numbers
			.stream()
			.filter(n -> n%2 != 0)
			.map(n -> n*n*n)
			.forEach(System.out::println);
			
	}
	
	
	private static void printNumOfCharInCourse(List<String> courses) {
		
		courses
			.stream()
			.map(c -> c + " " + c.length())
			.forEach(System.out::println);
		
	}
	

}





















