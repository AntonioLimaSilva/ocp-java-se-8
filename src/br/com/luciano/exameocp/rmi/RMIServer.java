package br.com.luciano.exameocp.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Luciano Lima
 *
 */
public class RMIServer {

	public static void main(String[] args) throws RemoteException {
		
		ContaBancaria conta = new ContaBancariaImpl();
		ContaBancaria contaStub = (ContaBancaria) UnicastRemoteObject.exportObject(conta, 0);
		
		Registry registry = LocateRegistry.createRegistry(1099);		
		registry.rebind("conta", contaStub);
		
		System.out.println("Aguardando requisições...");

	}

}
