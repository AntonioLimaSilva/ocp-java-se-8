package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();		
		Tarefa tarefa1 = new Tarefa(lista);
		Tarefa tarefa2 = new Tarefa(lista);
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		e.execute(tarefa1);
		e.execute(tarefa2);
		
		e.shutdown();
		
		while(!e.isTerminated()) {
			Thread.sleep(100);
		}
		
		for(int i = 0; i< 10; i++)
			System.out.printf("Indice no array %d\n", lista.obter(i));

	}

}
