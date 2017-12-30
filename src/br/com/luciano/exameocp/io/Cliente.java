package br.com.luciano.exameocp.io;

import java.io.Serializable;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Cliente implements Serializable {

	private int id;
	private String nome;
	private Endereco endereco;

	public Cliente(int id, String nome, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return String.format("[ID: %d] [Nome: %s] [Endereco: %s]", this.id, this.nome, this.endereco != null ? this.endereco.getNome() : null);
	}
}
