package br.com.luciano.exameocp.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Luciano Lima
 * 
 * Uma regra importante é que uma condition deve esta dentro de um look
 *
 */
public class Semaforo implements Runnable {
	
	private boolean aberto = false;
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	@Override
	public void run() {
		while(true) {
			this.lock.lock();	
			try {
				aberto = !aberto;
				System.out.println("Semáforo aberto: " + aberto);
				
				if(aberto) {
					// O signalAll acorda todas a threads que estão paradas nessa condicion
					this.condition.signalAll();
				}
			} finally {
				this.lock.unlock();
			}
			
			try {
				Thread.sleep(1000 + (int) (Math.random() * 4000));
			} catch(InterruptedException e) {}
		}		
	}

	/**
	 * Esse método é chamado pela classe carro, e acessa de forma concorrente o atributo aberto, junto com o semáforo,
	 * dessa forma é obrigatório o uso de lock, para garantir o acesso por uma única thread, só que quando feito isso
	 * surge um outro problema, que é causado pelo lock exclusivo, o método run do semáforo nunca vai ser executado, pelo
	 * fato do lock, e a aplicação aqui entrarar em um loop infinito, por que nunca o atributo aberto nunca fica verdadeiro,
	 * para resolver isso é preciso usar conditions, para interromper a execução das threads dos carros, e deixando as mesmas no estado
	 * de espera, ou dormindo, mas liberar o lock para as outras threads poder executar, dessa forma uma hora a thread do semáforo
	 * será executada e o atributo aberto mudará de valor, e mudando de valor é possivel notificar as threads que estão dormindo para
	 * elas poderem executar, dessa forma vai da certo por que da próxima vez que o método atravessar formado a condição do while vai ser
	 * false, e vai ser executado o códiog abaixo do while
	 * @param id
	 */
	public void atravessar(int id) {
		this.lock.lock();
		try {
			while(!aberto) {
				System.out.println("[Carro " + id + "] Aguardando");
				// O await deixa a thread dormindo, e libera o lock para outras threads poderem executar seu serviço, no final alguém
				// avisa para essa thread continuar sua execução, usando o método signal ou signalAll
				this.condition.await(); 
			}
			
			System.out.println("[Carro " + id + "] Atravessou");
		} catch(InterruptedException e) {
		} finally {
			this.lock.unlock();
		}
	}

}
