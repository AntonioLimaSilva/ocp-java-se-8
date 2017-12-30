package br.com.luciano.exameocp.lambda;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Empregado {
	
	private int id;
	private String nome;
	private String sobrenome;
	private double salario;
	private String departamento;
	
	public Empregado(int id, String nome, String sobrenome, double salario, String departamento) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public String getNomeCompleto() {
		return String.join(" ", getNome(), getSobrenome());
	}
	
	@Override
	public String toString() {
		return String.format("[%-8s %-8s %-8.2f %s]", getNome(), getSobrenome(), getSalario(), getDepartamento());
	}

}
