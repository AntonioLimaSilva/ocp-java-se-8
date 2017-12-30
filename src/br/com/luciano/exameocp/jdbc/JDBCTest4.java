package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Luciano Lima
 *
 */
public class JDBCTest4 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=crud";
		
		try (Connection conn = DriverManager.getConnection(url, "user", "****")) {
						
			String sql = "SELECT * FROM pessoa WHERE id > 10000";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// O executeQuery é utilizado em consultas que retornam dados, como por exemplo um select
			ResultSet result = stmt.executeQuery();			
			
			for(int count = 1; result.next(); count++) {
				String nome = result.getString(2);
				String email = result.getString(3);
				
				System.out.println(count + " Nome => " + nome);
				System.out.println(count + " Email => " + email);
				System.out.println("===========================");
			}
		} 
		
	}

}
