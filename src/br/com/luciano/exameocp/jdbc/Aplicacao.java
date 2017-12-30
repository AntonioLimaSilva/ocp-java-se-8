package br.com.luciano.exameocp.jdbc;

import java.sql.SQLException;

import br.com.luciano.exameocp.jdbc.dao.AutorDAO;
import br.com.luciano.exameocp.jdbc.model.Autor;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Aplicacao {

	public static void main(String[] args) {

		Autor autor = new Autor();
		autor.setFirstName("Ediane");
		autor.setLastName("Lima");
		
		AutorDAO autorDAO = new AutorDAO();
		
//		try {
//			int i = autorDAO.salvar(autor);
//			System.out.println(i);
//		} catch(SQLException e) {
//			
//		}
		
		try {
			autorDAO.todos().forEach(System.out::println);
		} catch(SQLException e) {
			
		}
		
//		Autor autorTemp = autorDAO.buscarPorId(6L);
//		autorTemp.setFirstName("Eliane");
//		autorTemp.setLastName("Lima");
//		
//		try {
//			int i = autorDAO.editar(autorTemp);
//			System.out.println(i);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}
