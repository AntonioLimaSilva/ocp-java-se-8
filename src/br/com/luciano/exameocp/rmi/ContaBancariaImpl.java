package br.com.luciano.exameocp.rmi;

import java.rmi.RemoteException;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ContaBancariaImpl implements ContaBancaria {
	
	private static final long serialVersionUID = 1L;
	
	private double saldo;

	@Override
	public void depositar(int valor) throws RemoteException {
		this.saldo += valor;		
	}

	@Override
	public void sacar(int valor) throws RemoteException {
		this.saldo -= valor;
	}

	@Override
	public void transferir(int valor, ContaBancaria outraConta) throws RemoteException {
		sacar(valor);
		outraConta.depositar(valor);
	}

	@Override
	public double getSaldo() throws RemoteException {
		return this.saldo;
	}	

}
