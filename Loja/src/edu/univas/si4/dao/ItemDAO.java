package edu.univas.si4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.univas.si4.entity.Item;

public class ItemDAO {

	private Connection connection;
	
	public ItemDAO() throws DAOException {
		connection = ConnectionFactory.createConnection();
	}
	
	public ItemDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Item item) throws DAOException {
		try {
			String sql = "INSERT INTO item (cod_pedido, cod_produto, quantidade) VALUES (?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, item.getOrderCode());
			statement.setInt(2, item.getProductCode());
			statement.setInt(3, item.getQuantity());
			
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
}
