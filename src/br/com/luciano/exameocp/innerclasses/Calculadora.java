package br.com.luciano.exameocp.innerclasses;

/**
 * 
 * @author luciano lima
 * 
 * É aconselhavel usar uma regular inner class, quando existe um relação bem próxima da inner class
 * com a outer class, e outro fator importante para ser uma regular inner class, é a classe soma ser um
 * atributo de outer class Calculadora.
 */
public class Calculadora {
	
	private int valor1;
	private int valor2;
	private int resultado;
	
	//Regular inner class
	private class Soma {
		public void somar() {
			Calculadora.this.resultado = Calculadora.this.valor1 + Calculadora.this.valor2;
		}
	}
	
	public void setValor1(int valor) {
		this.valor1 = valor;
	}
	
	public void setValor2(int valor) {
		this.valor2 = valor;
	}

	public int somar() {
		Soma soma = new Soma();
		soma.somar();
		return resultado;
	}
}
