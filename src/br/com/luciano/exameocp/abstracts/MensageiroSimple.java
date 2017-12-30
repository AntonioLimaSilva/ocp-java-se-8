package br.com.luciano.exameocp.abstracts;

/**
 * 
 * @author Luciano Lima
 *
 */
public abstract class MensageiroSimple implements Message {
	
	protected abstract String sendMessage();
	
	@Override
	public void method1() {
		System.out.println("METHOD1 MENSAGEIRO SIMPLE");
	}

	@Override
	public void method2() {
		System.out.println("METHOD2 MENSAGEIRO SIMPLE");
	}

	@Override
	public void method3() {
		System.out.println("METHOD3 MENSAGEIRO SIMPLE");
	}
}
