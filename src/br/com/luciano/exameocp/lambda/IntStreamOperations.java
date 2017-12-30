package br.com.luciano.exameocp.lambda;

import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * 
 * @author Luciano Lima
 *
 */
public class IntStreamOperations {

	public static void main(String[] args) {

		int [] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };
		
//		System.out.print("Original values: ");
//		IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
		
//		System.out.printf("%nCount: %d%n", IntStream.of(values).count());
//		OptionalInt optional =  IntStream.of(values).max();
//		System.out.printf("%nAqui o numero maior %n" + optional.getAsInt());
//		System.out.printf("%nMax: %d%n", IntStream.of(values).max().getAsInt());
//		
//		System.out.printf("%nSum: %d%n", IntStream.of(values).sum());
//		
//		System.out.printf("%nAverage: %.2f%n", IntStream.of(values).average().getAsDouble());

		//Soma os valores do array
//		System.out.printf("%nReduce: %d%n", IntStream.of(values).reduce(0, (x, y) -> x + y));
//		
//		//Soma as raizes quadradas do valores do array
//		System.out.printf("%nReduce: %d%n", IntStream.of(values).reduce(0, (x, y) -> x + y * y));
//		
		System.out.println("Imprimindo valores pares e exibindo em ordem crescente");
		IntStream.of(values)
			.filter(value -> value % 2 == 0)
			.sorted()
			.forEach(System.out::println);
		
//		System.out.println("Imprimindo valores impares e exibindo em ordem crescente");
//		IntStream.of(values)
//			.filter(value -> value % 2 != 0)
//			.sorted()
//			.forEach(System.out::println);
		
		System.out.println("Imprimindo valores impares multiplicado por 10 e exibindo em ordem crescente");
		IntStream.of(values)
			.filter(value -> value % 2 != 0)
			.map(value -> value * 10)
			.sorted()
			.forEach(System.out::println);	
		
		//Somar um intervalo de valores de 1 a 10	
//		System.out.printf("%nSum of integers from 1 to 9: %d%n", IntStream.range(0, 10).sum());
		
		// soma o intervalo dos números inteiros de 1 a 10, inclusive
		System.out.printf("Sum of integers from 1 to 10: %d%n", IntStream.rangeClosed(1, 10).sum());
		
	}

}
