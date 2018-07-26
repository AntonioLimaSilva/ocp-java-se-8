package br.com.luciano.generics;

import java.util.ArrayList;
import java.util.List;

class Person extends Object {
	@Override
	public String toString() {
		return String.format("%s", "Identificação da pessoa! ");
	}
}

class Customer extends Person {
	@Override
	public String toString() {
		return String.format("%s", "Identificação do cliente! ");
	}
}

public class TestWildCard {
	
	public static void main(String[] args) {
		List<Person> peoples = new ArrayList<>();
		peoples.add(new Person());
		peoples.add(new Customer());
		
		print(peoples);
		
	}
	
	static void print(List<? super Customer> elements) {
		elements.add(new Customer());
		
		elements.forEach(e -> System.out.println(e));
	}

}
