package br.com.luciano.exameocp.threads;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Leitor implements Runnable {
	
	private Info info;
	
	Leitor(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				String info2 = this.info.getInfo();
				System.out.println("Lendo info " + i + " => "  + info2);
				Thread.sleep(100);
			}
		} catch(InterruptedException e) {}
	}

}
