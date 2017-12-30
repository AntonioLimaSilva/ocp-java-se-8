package br.com.luciano.exameocp.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Gerador {
	
	private static AtomicInteger atomicInteger = new AtomicInteger(10);
	
	public static int getNumberActual() {
		return atomicInteger.getAndDecrement();
	}

}
