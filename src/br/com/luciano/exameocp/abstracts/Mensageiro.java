package br.com.luciano.exameocp.abstracts;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Mensageiro extends MensageiroSimple {
	
	private List<String> nomes = Arrays.asList("Antonio", "Francisco", "Ediane", "Eliane");

	@Override
	public void method1() {
		super.method1();
		System.out.println("METHOD1 MENSAGEIRO");
	}
	
	public static final void main(String args[]) {
		Mensageiro mensageiro = new Mensageiro();
		mensageiro.method1();
		mensageiro.sendMessage();
		System.out.println(mensageiro.sendMessage());
	}

	@Override
	protected String sendMessage() {
		return String.join("|", nomes);
	}
}
