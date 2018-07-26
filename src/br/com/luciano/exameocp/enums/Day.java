package br.com.luciano.enums;

public enum Day {

	MONDAY("Segunda"),
	TUESDAY("Terça"),
	WEDNESDAY("Quarta"),
	THUSDAY("Quinta"),
	FRIDAY("Sexta"),
	SANTUDAY("Sábado"),
	SANDY("Domingo");
	
	private String descricao;
	
	Day(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
