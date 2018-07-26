package br.com.luciano.innerclasses;

public class TesteInnerClass {
	
	static int i = 1;
	int y = 2;
	
	// Method local inner classes é possível acessar qualquer tipo variável externa ou seja da outer classe
	class Inner {
//		static void m() { // usar o static em métodos de inner classes gera um erro de compilação
//			System.out.println(i);
//		}
	}
	
	void m() {
		class B {
			void imprimir() {
				//i = 10; nesse caso não é final
				//y = 10;
				System.out.println(y);
			}
		}
	}

	public static void main(String[] args) {
		//Inner i = new TesteInnerClass().new Inner();
		//i.m();
		
		int b = 3;
		
		abstract class Cal {
			public abstract int calc(int x);
		}
		
		// Method local inner classes, no java 8 é possível acessar tanto variáveis locais, atributos e atributos statics
		Cal c = new Cal() {		
			@Override
			public int calc(int x) {
				return x - i + b;
			}
		};
		
		System.out.println(c.calc(2));
	}
	
	// Static inner classes podem acessar somente variáveis static de fora, o contrario não é verdadeiro
	static class C {
		void m() {
			//System.out.println(y); erro de compilação
			System.out.println(i);
		}
	}
	
}
