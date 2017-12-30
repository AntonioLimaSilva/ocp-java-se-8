package br.com.luciano.exameocp.cap01;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Outer {
	
	private final String msg = "Hello";
	
	/*
	 * Lembrando que é somente posssível a instanciação de Inner2 dentro de Inner1
	 */
	class Inner1 {
		int value = 3;
		
		public void method() {
			for(int i = 0; i < value; i++) {
				System.out.println(msg);
			}
		}		
		
		class Inner2 {
			int value = 2;
			
			public void m1() {
				System.out.println(this.value);
				System.out.println(Inner1.this.value);
				System.out.println(Outer.this.msg);
			}
		}
		
		public void textThis() {
			Inner2 inner2 = new Inner2();
			inner2.m1();
		}
	}
	
	public void printMessage() {
		Inner1 inner = new Inner1();
		inner.method();
		inner.textThis();
	}
	

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.printMessage();
	}
}
