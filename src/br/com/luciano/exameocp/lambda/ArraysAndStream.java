package br.com.luciano.exameocp.lambda;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ArraysAndStream {

	public static void main(String[] args) {

		String [] values = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
	
		System.out.printf("Elementos do array %s%n", Arrays.asList(values));
		
		int i = 'a';
		System.out.println(i);
		
//		Arrays.asList(values).stream()
//			.map(String::toUpperCase)
//			.forEach(System.out::println);
		
		System.out.printf("Elementos em caixa alta %s%n", Arrays.asList(values).stream().map(String::toUpperCase).collect(Collectors.toList()));

		System.out.printf("Elementos que vem depois de m em ordem crescente %s%n", Arrays.stream(values)
				.filter(s -> s.compareToIgnoreCase("m") > 0) // "m" na tabela unicode é representado pelo número 109
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList()));
		
		System.out.printf("Elementos que vem antes de m em ordem decrescente %s%n", Arrays.stream(values)
				.filter(s -> s.compareToIgnoreCase("m") < 0) // "m" na tabela unicode é representado pelo número 109
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.collect(Collectors.toList()));
				
	}
}
