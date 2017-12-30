package br.com.luciano.exameocp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ResultSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;
	private int numberOfRows;
	private boolean connectedToDatabase;
	
	ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
		this.connection = DriverManager.getConnection(url, username, password);		
		this.statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);		
		this.connectedToDatabase = true;			
		setQuery(query);
	}

	@Override
	public int getRowCount() {
		if(!connectedToDatabase) {
			throw new IllegalStateException("Não é possível conectar ao banco de dados!");
		}
		
		return this.numberOfRows;
	}

	@Override
	public int getColumnCount() {
		if(!connectedToDatabase) {
			throw new IllegalStateException("Não é possível conectar ao banco de dados!");
		}
		
		try {
			return this.resultSetMetaData.getColumnCount();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(!connectedToDatabase) {
			throw new IllegalStateException("Não é possível conectar ao banco de dados!");
		}
		
		try {
			this.resultSet.absolute(rowIndex + 1);
			return this.resultSet.getObject(columnIndex + 1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String getColumnName(int column) throws IllegalStateException {
		if(!connectedToDatabase) {
			throw new IllegalStateException("Não é possível conectar ao banco de dados!");
		}
		
		try {
			return this.resultSetMetaData.getCatalogName(column + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public void desconnectFromDatabase() {
		if(connectedToDatabase) {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}finally {
				this.connectedToDatabase = false;
			}
		}
	}
	
	public void setQuery(String query) throws SQLException {
		if(!connectedToDatabase)
			throw new IllegalStateException("Não é possível conectar ao banco de dados!");
		
		this.resultSet = this.statement.executeQuery(query);
		this.resultSetMetaData = this.resultSet.getMetaData();
		this.resultSet.last();
		this.numberOfRows = resultSet.getRow();
		
		fireTableDataChanged();
	}

}
