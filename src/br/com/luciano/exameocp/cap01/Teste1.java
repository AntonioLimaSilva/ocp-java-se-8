package br.com.luciano.exameocp.cap01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Teste1 {
	
	enum TipoPessoa {
		FISICA("Física"){
			public void m1() {
				System.out.println("Olá");
			}
		}, 
		
		JURIDICA("Jurídica");
		
		private String descricao;
		
		TipoPessoa(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		for(TipoPessoa tp : TipoPessoa.FISICA.values()) {
			System.out.println(tp);
		}
		
		List<Impressora> lista = new ArrayList<>();
		
		method(lista);
	}

	static void method(Collection<Impressora> impressora) {
		//impressora.imprimir("docx");
	}
}
