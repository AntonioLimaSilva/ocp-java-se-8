package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Cliente implements Runnable {
	
	private Conta conta;

	Cliente(Conta conta) {
		this.conta = conta;		
	}

	@Override
	public void run() {
		this.conta.depositar(100);
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {}
		
		this.conta.sacar(100);
	}

}
