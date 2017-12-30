package br.com.luciano.exameocp.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author Luciano Lima
 * 
 * Usar as classes e interfaces da api de concorrência do java é sem sombra de dúvida a melhor opção
 * para trabalhar com multiplas threads, por que ela já cuida de muita coisa, onde o programador não
 * precisa si preocupar. Casso essa implementação fosse feita da forma tradicional, o programador deveria
 * si preocupar com muitas outras coisas a parte, o usando a interface Runnable, teriamos implementar
 * outras formas para retornar o resultado, já que o método run devolve void, e o tratamento de excesões
 * também deveria ser feito de uma outra forma, já que a assinatura o método run, não permite jogar exception
 * para fora do método
 *
 */
public class Main5 {
	public static void main(String[] args) throws Exception {

		Mensagem mensagem = new Mensagem("Cobrança", "Bom dia, estou precisoando do meu dinheiro");
		Mensageiro mensageiro = new Mensageiro(mensagem);
		FutureTask<String> task = new FutureTask<>(mensageiro);
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(task);		
		
		service.shutdown();
		
		while(!task.isDone()) {
			System.out.println("Aguarde um momento...");
			Thread.sleep(1000);
		}
		
		try {
			String conteudo = task.get();
			System.out.println(conteudo);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getCause());
		}
		
		System.out.println("Fim do método main");
	}
}
