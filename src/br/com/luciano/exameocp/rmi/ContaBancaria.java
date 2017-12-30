package br.com.luciano.exameocp.rmi;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Luciano Lima
 *
 */
public interface ContaBancaria extends Remote, Serializable {
	
	void depositar(int valor) throws RemoteException;
	
	void sacar(int valor) throws RemoteException;
	
	void transferir(int valor, ContaBancaria contaBancaria) throws RemoteException;
	
	double getSaldo() throws RemoteException;

}
