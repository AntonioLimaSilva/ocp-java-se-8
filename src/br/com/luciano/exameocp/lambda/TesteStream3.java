package br.com.luciano.exameocp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TesteStream3 {
	
	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();		
		int array[] = new int[] {1, 8, 2, 3, 4, 7};
		
		produtos.add(new Produto(1, "Video Game", 250.0));
		produtos.add(new Produto(2, "TV LCD", 950.0));
		produtos.add(new Produto(3, "Playstation", 300.0));
		produtos.add(new Produto(4, "Microondas", 750.0));	
		
		double resultMedia = media(produtos);
		double resultSoma = soma(produtos);
		double result1 = methodReduce(produtos);
		int result2 = somarElemento(array);
		long total = total(produtos);
		
		System.out.println(resultMedia);
		System.out.println(resultSoma);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(total);

	}
	
	private static double media(List<? extends Produto> produtos) {
		return produtos.stream()
				.mapToDouble(p -> p.getPreco())
				.average()
				.getAsDouble();
	}
	
	private static double soma(List<? extends Produto> produtos) {
		return produtos.stream()
				.mapToDouble(Produto::getPreco)
				.sum();
	}
	
	private static int somarElemento(int [] array) {	
		return Arrays.stream(array)
				.reduce((x, y) -> (x + y))
				.getAsInt();
	}
	
	private static double methodReduce(List<? extends Produto> protudos) {
		return protudos.stream()
				.map(Produto::getPreco)
				.reduce((x, y) -> x + y)
				.orElse(0.0);
	}
	
	/**
	 * 
	 * @param protudos
	 * @return total de produto dentro da lista
	 */
	private static long total(List<? extends Produto> protudos) {
		return protudos.stream()
				.count();
	}

}
