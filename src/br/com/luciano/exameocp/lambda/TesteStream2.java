package br.com.luciano.exameocp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TesteStream2 {
	
	private static List<Produto> produtos;	
	private static int array[] = {1, 8, 2, 3, 4, 7};
	
	static {
		produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Video Game", 250.0));
		produtos.add(new Produto(2, "TV LCD", 950.0));
		produtos.add(new Produto(3, "Playstation", 300.0));
		produtos.add(new Produto(4, "Microondas", 750.0));
	}

	public static void main(String[] args) {
		
		executar6();

	}
	
	static void executar1() {
		Optional<Double> reduce = produtos.stream()
			.map(Produto::getPreco)
			.reduce((value1, value2) -> value1 + value2);
		System.out.println(reduce.get());
		
	}
	
	/**
	 * Ordenando uma lista de produtos em ordem crescente, e mapeando o atributo preco para alterar o seu valor, nesse
	 * caso usando uma variável externa, isso é chamado de closeres
	 */
	static void executar2() {
		double cotacao = 4;
		produtos.stream()
			.sorted((p1, p2) -> new Double(p1.getPreco()).compareTo(p2.getPreco()))
			.map(p -> new Produto(p.getId(), p.getNome(), p.getPreco() / cotacao))
			.forEach(p -> System.out.println(p.getNome() + " -> " + p.getPreco()));		
	}
	
	/**
	 * Criando Mapa a partir de uma lista de produtos
	 */
	static void executar3() {
		produtos.stream()
			.collect(Collectors.toMap(p1 -> p1.getId(), p2 -> p2.getNome()))
			.forEach((chave, valor) -> System.out.println(chave + " -> " + valor));		
	}
	
	/**
	 * Transformando uma lista de produtos em uma representação de strings
	 */
	static void executar4() {
		String resultado = produtos.stream()
			.map(p -> String.format("{%d:%s:%.2f}", p.getId(), p.getNome(), p.getPreco()))
			.collect(Collectors.joining(";"));
		
		System.out.println(resultado);
	}
	
	/**
	 * Obtendo a soma dos preços de cada produto da lista
	 */
	static void executar5() {
		double sum = produtos.stream()
			.mapToDouble(Produto::getPreco)
			.sum();
		
		System.out.println(sum);
	}
	
	/**
	 * Transformando um array em um objeto intStream, ordenando e depois obtendo a média
	 */
	static void executar6() {
		IntStream intStream = Arrays.stream(array);
		
		double result = intStream
			.sorted()
			.average()
			.orElse(0);
		
		System.out.println(result);
	}

}
