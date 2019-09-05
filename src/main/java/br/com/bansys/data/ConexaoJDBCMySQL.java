package br.com.bansys.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJDBCMySQL {
	
	public Connection getConnection();

	public void close();

	public void commit() throws SQLException;

	public void rollback();
	
}
