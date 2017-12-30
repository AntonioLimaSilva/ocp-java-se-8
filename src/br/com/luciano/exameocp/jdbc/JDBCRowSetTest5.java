package br.com.luciano.exameocp.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * 
 * @author Luciano Lima
 *
 */
public class JDBCRowSetTest5 {
	
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=crud";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "****";

	public static void main(String[] args) {
		
		try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {
			rowSet.setUrl(DATABASE_URL);
			rowSet.setUsername(USERNAME);
			rowSet.setPassword(PASSWORD);
			rowSet.setCommand("SELECT * FROM pessoa");
			rowSet.execute();
			
			ResultSetMetaData metaData = rowSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			System.out.printf("Pessoas do banco de dados:%n%n");
			
			for(int i = 1; i <= numberOfColumns; i++) {
				String columnName = metaData.getColumnName(i);
				System.out.printf("%-8s\t", columnName);
			}
			
			System.out.println();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

}
