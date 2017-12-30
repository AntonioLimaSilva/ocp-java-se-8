package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Escritor implements Runnable {
	
	private Info info;

	public Escritor(Info info) {
		this.info = info;	
	}

	@Override
	public void run() {	
		try {
			for(int i = 0; i < 10; i++) {
				this.info.setInfo();
				Thread.sleep(100);
			}
		} catch(InterruptedException e) {}
	}

}
