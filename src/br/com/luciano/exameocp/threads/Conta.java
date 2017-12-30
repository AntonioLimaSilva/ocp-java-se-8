package br.com.luciano.exameocp.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Conta {
	
	private ReentrantLock lock = new ReentrantLock();
	private double saldo;
	
	/**
	 * Aqui nos temos uma região crítica do código, essas regiões devem ser encontradas pelo
	 * programador, para serem tratadas, nesse caso é possível usar o modificar synchronized do java
	 * ou usar a nova API do java, um objeto do tipo ReentrantLock tem a fusão de sincronizar o acesso
	 * a esse método
	 * @param valor
	 */
	public void depositar(double valor) {
		this.lock.lock();
		try {
			this.saldo += valor;
		} finally {
			this.lock.unlock();
		}
	}
	
	/**
	 * Aqui nos temos uma região crítica do código, essas regiões devem ser encontradas pelo
	 * programador, para serem tratadas, nesse caso é possível usar o modificar synchronized do java
	 * ou usar a nova API do java, um objeto do tipo ReentrantLock tem a fusão de sincronizar o acesso
	 * a esse método
	 * @param valor
	 */
	public void sacar(double valor) {
		this.lock.lock();
		try {
			this.saldo -= valor;
		} finally {
			this.lock.unlock();
		}
	}
	
	/**
	 * Aqui não é necessário sincronizar o acesso há esse método, já que ele é chamado somente, ao termino
	 * da execusão dos métodos depositar e sacar, e nesse caso é chamado na thread principal, ou seja, não existe
	 * existe concorrência a esse método
	 * @return Saldo
	 */
	public double getSaldo() {
		return this.saldo;
	}

}
