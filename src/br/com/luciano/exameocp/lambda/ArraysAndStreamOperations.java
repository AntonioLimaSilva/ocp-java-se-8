package br.com.luciano.exameocp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ArraysAndStreamOperations {

	public static void main(String[] args) {

		Integer [] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };
	
		System.out.printf("Elementos do array %s%n", Arrays.asList(values));
		
		System.out.printf("Ordenar valores %s%n", 
			Arrays.asList(values).stream()
				.sorted()
				.collect(Collectors.toList())
			);
		
		
		List<Integer> lista = Arrays.asList(values).stream()
			.filter(value -> value > 4)
			.sorted()
			.collect(Collectors.toList());
				
		System.out.printf("Filtrar elementos e ordenando os valores %s%n", 
			lista.stream()
				.sorted()
				.collect(Collectors.toList())
			);
		
	}
}
