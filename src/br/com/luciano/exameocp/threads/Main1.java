package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main1 {

	public static void main(String[] args) {

		//ExecutorService e = Executors.newSingleThreadExecutor();
		ExecutorService e = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i <= 5; i++) {
			Task task = new Task(i);
			e.execute(task);
		}		
		
		e.shutdown();
	}

}
