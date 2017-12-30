package br.com.luciano.exameocp.innerclasses;

public class InnerClassMethodTest {
	
	public static void main(String[] args) {
		final String t = "Olá";

		class InnnerClass {			
			public void imprimir() {
				System.out.println(t);
			}
		}
		
		InnnerClass innnerClass = new InnnerClass();
		innnerClass.imprimir();
		
	}
	
}
