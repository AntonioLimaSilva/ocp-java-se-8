package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main4 {
	
	private static final int NUM_CARRO = 5;

	public static void main(String[] args) {
		
		ExecutorService e = Executors.newFixedThreadPool(NUM_CARRO + 1);
		Semaforo semaforo = new Semaforo();
		e.execute(semaforo);
		
		for(int i = 0; i < NUM_CARRO; i++) {
			Carro carro = new Carro(i, semaforo);
			e.execute(carro);
		}
		
		e.shutdown();
	}

}
