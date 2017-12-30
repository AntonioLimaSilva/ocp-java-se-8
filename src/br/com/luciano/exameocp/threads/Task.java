package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Task implements Runnable {

	private int id;
	
	public Task(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.printf("=== Inciando %d ===\n", id);
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {};
		
		System.out.printf("=== finalizando %d ===\n", id);
	}

}
