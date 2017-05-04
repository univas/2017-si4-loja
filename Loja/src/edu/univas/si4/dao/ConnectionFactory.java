package edu.univas.si4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection createConnection() throws DAOException {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5433/loja", "postgres", "abc123");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
}
