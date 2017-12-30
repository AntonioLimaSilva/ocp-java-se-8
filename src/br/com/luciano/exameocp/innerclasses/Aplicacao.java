package br.com.luciano.exameocp.innerclasses;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Aplicacao {

	public static void main(String[] args) {
		
		Calculadora c1 =  new Calculadora();
		c1.setValor1(150);
		c1.setValor2(40);
		
		System.out.printf("Result %d\n", c1.somar());
		
		StaticInnerClass.Bebida b1 = new StaticInnerClass.Bebida();
		b1.imprimir();

	}

}
