package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Luciano Lima
 *
 */
public class PessoaQueries {
	
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=crud";
	private final static String USERNAME = "user";
	private static final String PASSWORD = "****";
	
	private Connection connection;
	private PreparedStatement findAll;
	private PreparedStatement findByName;
	private PreparedStatement insert;
	
	public PessoaQueries() {
		try {
			this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			this.findAll = this.connection.prepareStatement("SELECT * FROM pessoa ORDER BY id ASC");
			
			this.findByName = this.connection.prepareStatement("SELECT * FROM pessoa WHERE nome LIKE ? ORDER BY id ASC");
			
			this.insert = this.connection.prepareStatement("INSERT INTO pessoa (nome, email) VALUES (?, ?)");
		} catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Pessoa> getAllPeaple() {
		ResultSet resultSet = null;
		List<Pessoa> results = null;
		try {
			resultSet = this.findAll.executeQuery();
			results = new ArrayList<>();
			
			while(resultSet.next()) {
				results.add(new Pessoa(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch(SQLException e) {
				e.printStackTrace();
				close();
			}
		}
		
		return results;
	}
	
	public List<Pessoa> getPeapleByName(String nome) {
		ResultSet resultSet = null;
		List<Pessoa> results = null;
		
		try {
			this.findByName.setString(1, nome + "%");
			resultSet = this.findByName.executeQuery();			
			results = new ArrayList<>();
			
			while(resultSet.next()) {
				results.add(new Pessoa(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch(SQLException e) {
				e.printStackTrace();
				close();
			}
		}
		
		return results;
	}
	
	public int save(Pessoa pessoa) {
		int result = 0;
		try {
			this.insert.setString(1, pessoa.getNome());
			this.insert.setString(2, pessoa.getEmail());
			result = this.insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insert.close();
			} catch (SQLException e) {
				e.printStackTrace();
				close();
			}
		}
		
		return result;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
