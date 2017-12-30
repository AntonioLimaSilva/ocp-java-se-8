package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
 * @author Luciano Lima
 *
 */
public class JDBCTest2 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=crud";
		
		try (Connection conn = DriverManager.getConnection(url, "user", "****")) {
			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO pessoa VALUES('Henrique', 'henrique@gmail.com')";
			stmt.executeUpdate(sql);			
		} 
		
	}

}
