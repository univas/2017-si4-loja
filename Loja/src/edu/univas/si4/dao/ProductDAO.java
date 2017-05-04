package edu.univas.si4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.univas.si4.entity.Product;

public class ProductDAO {

	private Connection connection;
	
	public ProductDAO() throws DAOException {
		connection = ConnectionFactory.createConnection();
	}
	
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Product findForUpdate(int code) throws DAOException {
		try {
			String sql = "SELECT * FROM produto WHERE cod = ? FOR UPDATE";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, code);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Product product = new Product();
				
				product.setCode(code);
				product.setName(result.getString("nome"));
				product.setBalance(result.getInt("saldo"));
				
				return product;
			} else {
				return null;
			}
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void insert(Product product) throws DAOException {
		try {
			String sql = "INSERT INTO produto (cod, nome, saldo) VALUES (?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, product.getCode());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getBalance());
			
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}

	public void update(Product product) throws DAOException {
		try {
			String sql = "UPDATE produto set nome = ?, saldo = ? WHERE cod = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setInt(2, product.getBalance());
			statement.setInt(3, product.getCode());
			
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}

	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Product>();
	}
	
}
