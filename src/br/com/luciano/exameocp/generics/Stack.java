package br.com.luciano.exameocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Stack<T> {
	
	private final List<T> elements;
	
	public Stack() {
		this(10);
	}
	
	/**
	 * Nesse construtor é feito uma verificação, caso o valor seja negativo resultara em false,
	 * dessa forma terá um valor padrão de 10 caso o valor do capacity seja negativo
	 * @param capacity
	 */
	public Stack(int capacity) {
		int initCapacity = capacity > 0 ? capacity : 10;
		this.elements = new ArrayList<>(initCapacity);
	}

	public void push(T element) {
		this.elements.add(element);
	}
	
	public T pop() {
		if(elements.isEmpty())
			throw new EmptyStackException("A Stack esta vazia!");
		
		return this.elements.remove(elements.size() - 1);
	}
	
}
