package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main2 {

	public static void main(String[] args) throws InterruptedException {
		
		Conta conta = new Conta();
		
		Cliente cliente1 = new Cliente(conta);
		Cliente cliente2 = new Cliente(conta);
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.execute(cliente1);
		e.execute(cliente2);
		
		e.shutdown();
		
		while(!e.isTerminated()) {
			Thread.sleep(10000);
		}
		
		System.out.println("valor do saldo: " + conta.getSaldo());
	}

}
