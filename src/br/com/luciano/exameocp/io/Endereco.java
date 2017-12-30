package br.com.luciano.exameocp.io;

import java.io.Serializable;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Endereco implements Serializable {

	private int id;
	private String nome;
	private int numero;
	
	Endereco(int id, String nome, int numero) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return String.format("[ID: %d] [Nome: %s] [Número: %d]", this.id, this.nome, this.numero);
	}
}
