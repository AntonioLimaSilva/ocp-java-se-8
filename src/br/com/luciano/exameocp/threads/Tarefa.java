package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Tarefa implements Runnable {
	
	private Lista lista;

	public Tarefa(Lista lista) {
		this.lista = lista;		
	}

	@Override
	public void run() {
		for(int i = 0;i<5; i++) {
			this.lista.add(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
