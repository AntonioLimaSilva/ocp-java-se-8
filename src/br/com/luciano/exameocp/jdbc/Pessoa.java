package br.com.luciano.exameocp.jdbc;

import com.microsoft.sqlserver.jdbc.StringUtils;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Pessoa {

	private Long id;
	private String nome;
	private String email;
	
	public Pessoa() {}
	
	public Pessoa(Long id, String nome, String email) {
		this.id = id;
		this.nome = StringUtils.isEmpty(nome) ? null : nome.trim();
		this.email = StringUtils.isEmpty(email) ? null : email.trim();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = StringUtils.isEmpty(nome) ? nome : nome.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = StringUtils.isEmpty(email) ? email : email.trim();
	}
	
	@Override
	public String toString() {
		return "[id = " + id + " ] [ nome = " + nome + " ] [email = " + email + "]" ;
	}
}
