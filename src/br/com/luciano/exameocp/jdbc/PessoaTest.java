package br.com.luciano.exameocp.jdbc;

/**
 * 
 * @author Luciano Lima
 *
 */
public class PessoaTest {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Rita Andreia Lima");
		pessoa.setEmail("rita@gmail.com");
		
		PessoaQueries pessoaQueries = new PessoaQueries();
		//int result = pessoaQueries.save(pessoa);
		
		//System.out.println("Resultado = " + result);
		
		//pessoaQueries.getAllPeaple().forEach(System.out::println);
		
		pessoaQueries.getPeapleByName("Rita").forEach(System.out::println);
	}

}
