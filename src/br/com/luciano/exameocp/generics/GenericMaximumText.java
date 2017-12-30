package br.com.luciano.exameocp.generics;

/**
 * 
 * @author Luciano Lima
 *
 */
public class GenericMaximumText {

	public static void main(String[] args) {

		System.out.printf("Maximum of %d, %d and %d is %d%n%n", 3, 4, 5, maximum(3, 4, 5));
		System.out.printf("Maximum of %.2f, %.2f and %.2f is %.2f\n\n", 7.0, 8.0, 9.0, maximum(7.0, 8.0, 9.0));
		System.out.printf("Maximum of %s, %s and %s is %s\n\n", "azul", "vermelho", "amarelo", maximum("azul", "vermelho", "amarelo"));
		
	}
	
	/**
	 * Aqui não da certo usar a estrutura if e if else, por que essa estrutura obtem o primeiro if como true
	 * e não vai verificar o if else seguinte, já que o primeiro if já deu true, nessa caso a melhor opção
	 * seria usar os dois ifs, como segue abaixo, por que mesmo o primeiro if sendo true, e a atribuição do valor
	 * em max sendo feita, o segundo if vai true também e vai ser atribuido novamente em max e então
	 * terá o valor max dos três valores nesse exemplo.
	 * @param x
	 * @param y
	 * @param z
	 * @return max
	 */
	private static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // x = 6, y = 4, z = 5
		
		if(y.compareTo(max) > 0) {
			max = y;
		} 
		
		if(z.compareTo(max) > 0) {
			max = z;
		}
		
		return max;
	}

}
