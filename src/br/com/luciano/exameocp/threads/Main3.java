package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main3 {
	
	public static void main(String[] args) {
		
		Info info = new Info();		
		Leitor leitor = new Leitor(info);
		Escritor escritor = new Escritor(info);		
		ExecutorService e = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 5; i++) {
			e.execute(escritor);
		}
		
		for(int i = 0; i < 5; i++) {
			e.execute(leitor);
		}
				
		e.shutdown();
		
	}
	
}
