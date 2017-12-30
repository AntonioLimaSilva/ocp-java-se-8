package br.com.luciano.exameocp.generics;

import java.util.Arrays;

/**
 * 
 * @author Luciano Lima
 *
 */
public class OverloadText {

	public static void main(String[] args) {
		Integer arrayInteger[] = new Integer[]{1, 2, 3, 4, 5};
		
		Double []arrayDouble = new Double[5];
		arrayDouble[0] = 10.00;
		arrayDouble[1] = 11.00;
		arrayDouble[2] = 12.00;
		arrayDouble[3] = 13.00;
		arrayDouble[4] = 14.00;
		
		Character arrayCharacter[] = {'C', 'V', 'B', 'F'};
		
		/**
		 * Aqui é recurso de sobrecarga de método
		 */
		printArray(arrayCharacter);
		printArray(arrayDouble);
		printArray(arrayInteger);
	}
	
	static void printArray(Integer[] array) {
		for(Integer i : array) {
			System.out.println(i);
		}
	}
	
	static void printArray(Double[] array) {
		Arrays.asList(array).forEach(System.out::println);
	}
	
	static void printArray(Character[] array) {
		Arrays.asList(array).forEach(System.out::println);
	}

}
