package programming;

import java.util.List;

public class FP01Functional {
	
	

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		printAllNumberInListStructured(numbers);
		
		System.out.println(" ");
		
		printEvenNumberInListStructured(numbers);
		
		System.out.println(" ");
		
		printSquaresEvenNumberInListStructured(numbers);
	}
	

	private static void printAllNumberInListStructured(List<Integer> numbers) {

		numbers.stream()
			.forEach(System.out::println); // Loop the numbers and call a Method Reference

	}

	private static void printEvenNumberInListStructured(List<Integer> numbers) {

		numbers.stream()
			.filter(number -> number%2 == 0) //Lambda Expression 
			.forEach(System.out::println); // Loop the numbers and call a Method Reference

	}
	
	private static void printSquaresEvenNumberInListStructured(List<Integer> numbers) {

		numbers.stream()
			.filter(number -> number%2 == 0) //Lambda Expression 
			.map(n -> n*n) // Map the data, in this case to n^2 (only the ones that pass the filter)
			.forEach(System.out::println); // Loop the numbers and call a Method Reference

	}

}
