package br.com.luciano.exameocp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TesteLambdas {

	public static void main(String[] args) {
		
		String nome = "antonio";
		List<String> nomes = Arrays.asList("Carlos", "Joaquim", "Luiz", "João");
		List<Integer> numeros = new ArrayList<>();
		numeros.add(1);numeros.add(2);numeros.add(3);numeros.add(4);numeros.add(5);
		
		numeros.removeIf((Integer i) -> i % 2 != 0);
		
		numeros.forEach(System.out::println);
		
		nomes.forEach(System.out::println);
		
		Consumer<String> maiuscula = (String) -> System.out.println(nome.toUpperCase());
		maiuscula.accept(nome);
		
		Predicate<String> tamanhoMaior = (String) -> {return nome.length() > 10;}; 
		System.out.println(tamanhoMaior.test(nome));
		
		Runnable r = () -> System.out.println("Ola");
		r.run();
		
	}

}
