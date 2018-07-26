package br.com.luciano.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestLambda1 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(6);
		list.add(3);
		list.add(4);
		
		//list.replaceAll(i -> i + 1);
		
		//list.removeIf(i -> i % 2 != 0);
		
		//list.sort((x, y) -> Integer.compare(x, y));
		
		//list.spliterator();
		
		//list.forEach(System.out::println);
		
		//new Thread(() -> System.out.println("ABC")).start();
		
		TestLambda1.method(i -> i % 2 != 0, list);
		
	}
	
	static void method(Predicate<Integer> p, List<Integer> list) {
		int y = 1;
		list.forEach(i -> { System.out.println(p.test(i + y)); });
	}

}
