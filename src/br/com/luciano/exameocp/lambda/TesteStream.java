package br.com.luciano.exameocp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TesteStream {
	
	private static List<String> nomes = Arrays.asList("televião", "rádio", "dvd", "geladeira", "microondas");

	public static void main(String[] args) {
		
		//method1();
		//method2();
		method3();
	}
	
	/**
	 * Operação intermediária
	 * Pega os três primeiros elementos da lista e percorre cada elemento imprimindo no console
	 */
	static void method1() {
		nomes.stream()
			.limit(3)
			.forEach(System.out::println);
	}
	
	/**
	 * Operação intermediária
	 * Filtra os elementos da lista, dado um critério de comparação e retorno uma lista desse elementos
	 * 
	 */
	static void method2() {
		List<String> collect = nomes.stream()
			.filter(s -> s.contains("d"))
			.collect(Collectors.toList());
		
		collect.forEach(System.out::println);
	}
	
	/**
	 * Operação terminal
	 * Retorno a soma de todos os caracteres das string de cada nome
	 */
	static void method3() {
		int count = nomes.stream()
			.collect(Collectors.summingInt(String::length));
		
		System.out.println(count);
	}

}
