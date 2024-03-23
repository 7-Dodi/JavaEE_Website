package br.com.JavaWeb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManufature {

	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/nomeDoBancoDeDados", "postgres", "suaSenha");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
