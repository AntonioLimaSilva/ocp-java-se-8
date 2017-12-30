package br.com.luciano.exameocp.generics;

/**
 * 
 * @author Luciano Lima
 *
 */
public class StackText {

	public static void main(String[] args) {

		String [] elements = new String[]{"Lima", "Silva", "Oliveira", "Mesquita"};
		Stack<String> stack1 = new Stack<>(10);
		
		testPush("String", stack1, elements);
		System.out.println(stack1.pop());
	}
	
	static <T> void testPush(String nome, Stack<T> stack, T [] elements) {
		System.out.println("Elementos do array de " + nome);
		for(T element : elements)
			stack.push(element);
	}

}
