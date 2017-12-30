package br.com.luciano.exameocp.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.luciano.exameocp.jdbc.model.Autor;
import br.com.luciano.exameocp.jdbc.util.factory.ConnectionFactory;

/**
 * 
 * @author Luciano Lima
 *
 */
public class AutorDAO {
	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	
	public Autor buscarPorId(Long id) {
		String sql = "SELECT * FROM autores WHERE id = ?";
		try {
			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setLong(1, id);
			this.result = this.preparedStatement.executeQuery();
			if(result.next()) {
				return new Autor(result.getLong(1), result.getString(2), result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		throw new IllegalArgumentException("Autor não encontrado!");
	}
	
	public int salvar(Autor autor) throws SQLException {	
		String sql = "INSERT INTO autores (firstName, lastName) VALUES (?, ?)";
		try {
			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setString(1, autor.getFirstName());
			this.preparedStatement.setString(2, autor.getLastName());		
			return preparedStatement.executeUpdate();
		} finally {
			close();
		}
	}
	
	public int editar(Autor autor) throws SQLException {
		String sql = "UPDATE autores SET firstName = ?, lastName = ? WHERE id = ?";
		try {
			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setString(1, autor.getFirstName());
			this.preparedStatement.setString(2, autor.getLastName());
			this.preparedStatement.setLong(3, autor.getId());
			return this.preparedStatement.executeUpdate();
		} finally {
			close();
		}
	}
	
	public List<Autor> todos() throws SQLException {
		List<Autor> autores = null;
		String sql = "SELECT * FROM autores ORDER BY id DESC";
		try {
			this.preparedStatement = this.connection.prepareStatement(sql);
			this.result = this.preparedStatement.executeQuery();
			autores = new ArrayList<>();
			while(result.next()) {
				autores.add(new Autor(result.getLong(1), result.getString(2), result.getString(3)));
			}		
			return autores;
		} finally {
			close();
		}
	}

	public void close() {
		try {
			this.connection.close();
			this.preparedStatement.close();
			this.result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}