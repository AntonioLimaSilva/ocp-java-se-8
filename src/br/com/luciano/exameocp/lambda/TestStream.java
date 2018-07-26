package br.com.luciano.lambdas;

import java.util.ArrayList;
import java.util.List;

class Pessoa {
	
	private String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}

public class TestStream {

	public static void main(String[] args) {

		List<String> nomes = new ArrayList<>();
		nomes.add("Antonio Lima");
		nomes.add("Luiz Souza");
		nomes.add("André Linhares");
		nomes.add("Carlos Gomes");
		
		//List<Pessoa> collect = nomes.stream().map(Pessoa::new).collect(Collectors.toList());
		
		//collect.forEach(p -> System.out.println(p.getNome()));
		
		Pessoa p1 = nomes.stream().map(Pessoa::new).filter(p -> p.getNome().contains("Luiz Souza")).findAny().orElse(new Pessoa(""));
		
		System.out.println(p1.getNome());
		
	}

}
