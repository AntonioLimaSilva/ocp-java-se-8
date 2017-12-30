package br.com.luciano.exameocp.generics;

/**
 * 
 * @author Luciano Lima
 *
 */
public class GenericText {

	public static void main(String[] args) {
		
		Integer arrayInteger[] = new Integer[]{1, 2, 3, 4, 5};
		
		//O generics não si aplica para tipos primitivos
		int arrayInt[] = new int[]{1, 2, 3, 4, 5};
		
		Double []arrayDouble = new Double[5];
		arrayDouble[0] = 10.00;
		arrayDouble[1] = 11.00;
		arrayDouble[2] = 12.00;
		arrayDouble[3] = 13.00;
		arrayDouble[4] = 14.00;
		
		Character arrayCharacter[] = {'C', 'V', 'B', 'F'};
		
		printArray(arrayInteger);
		printArray(arrayDouble);
		printArray(arrayCharacter);
		//printArray(arrayInt); Não compila
	}

	static <T> void printArray(T[] array) {
		for (T i : array) {
			System.out.println(i);
		}
	}
}
