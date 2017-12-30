package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
 * @author Luciano Lima
 *
 */
public class JDBCTest1 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=crud";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, "user", "****");
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO pessoa VALUES('Carlos', 'carlos@gmail.com')";
			stmt.executeUpdate(sql);		
		} finally {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
		}
		
	}

}
