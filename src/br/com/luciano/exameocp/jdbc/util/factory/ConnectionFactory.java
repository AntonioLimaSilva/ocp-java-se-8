package br.com.luciano.exameocp.jdbc.util.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(UtilConnection.DATABASE_URL, UtilConnection.USERNAME, UtilConnection.PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
