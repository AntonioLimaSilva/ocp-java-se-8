package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Mensagem {

	private String nome;
	private String conteudo;
	
	public Mensagem(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
	}

	public String getNome() {
		return nome;
	}

	public String getConteudo() {
		return conteudo;
	}

}
