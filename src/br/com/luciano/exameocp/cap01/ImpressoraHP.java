package br.com.luciano.exameocp.cap01;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ImpressoraHP implements Impressora {

	@Override
	public void imprimir(String documento) {
		System.out.printf("Imprimindo csv %s", documento);
	}

}
