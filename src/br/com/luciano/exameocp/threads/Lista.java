package br.com.luciano.exameocp.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Lista {
	
	private int[] array = new int[10];
	private int indice;
	private ReentrantLock lock = new ReentrantLock();
	
	public void add(int elemento) {
		this.lock.lock();
		try {
			this.array[indice] = elemento;
			this.indice++;
		}finally {
			this.lock.unlock();
		}
	}

	public int obter(int indice) {
		this.lock.lock();
		try {
			int elemento = this.array[indice];
			return elemento;
		} finally {
			this.lock.unlock();		
		}
	}
}
