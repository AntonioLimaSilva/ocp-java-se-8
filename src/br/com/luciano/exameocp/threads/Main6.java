package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main6 {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			int number = Gerador.getNumberActual();
			System.out.println(number);
		}
		
	}
}
