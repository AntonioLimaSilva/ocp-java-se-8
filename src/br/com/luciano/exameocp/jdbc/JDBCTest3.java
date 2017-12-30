package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 
 * @author Luciano Lima
 *
 */
public class JDBCTest3 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=crud";
		
		try (Connection conn = DriverManager.getConnection(url, "user", "****")) {
						
			String sql = "INSERT INTO pessoa VALUES(?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "sergio");
			stmt.setString(2, "sergio@gmail.com");
			
			stmt.executeUpdate();			
		} 
		
	}

}
