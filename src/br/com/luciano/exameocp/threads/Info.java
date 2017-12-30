package br.com.luciano.exameocp.threads;

import java.security.SecureRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Info {
	
	private String msg = "AAAAAAA";
	private SecureRandom random = new SecureRandom();
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private Lock rl = rwl.readLock();
	private Lock wl = rwl.writeLock();
	
	public void setInfo() {
		this.wl.lock();
		try {
			msg = "";
			for(int i = 0; i < 10; i++) {
				char c = (char) (random.nextInt(26) + 65);
				msg += c;
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		} finally {
			this.wl.unlock();
		}
	}

	public String getInfo() {
		try {
			this.rl.lock();
			return msg;
		} finally {
			this.rl.unlock();
		}
	}
}
