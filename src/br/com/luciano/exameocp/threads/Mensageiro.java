package br.com.luciano.exameocp.threads;

import java.util.concurrent.Callable;

/**
 * 
 * @author Luciano Lima
 * 
 * A interface Callable é usada para criar tarefas futuras, onde a thread principal no futuro ler o
 * resultado da thread secundaria, no caso a thread secundária é a classe Mensageiro
 *
 */
public class Mensageiro implements Callable<String> {
	
	private Mensagem mensagem;
	
	public Mensageiro(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String call() throws Exception {
		if(mensagem.getNome() == null || mensagem.getConteudo() == null)
			throw new RuntimeException("Nome e conteúdo não pode ser vazios");
			
		Thread.sleep(3000);
		
		System.out.println("Enviando mensagem: " + mensagem.getNome());
		return mensagem.getConteudo();
	}

}
