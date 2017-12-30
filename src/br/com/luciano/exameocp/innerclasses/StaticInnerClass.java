package br.com.luciano.exameocp.innerclasses;

/**
 * 
 * @author Luciano Lima
 *
 *Caracteristas da static inner class, não acessa atributos de sua outer class
 */
public class StaticInnerClass {
	
	public static class Bebida {
		public void imprimir() {
			System.out.println("Preparando o chá!");
		}
	}

}
