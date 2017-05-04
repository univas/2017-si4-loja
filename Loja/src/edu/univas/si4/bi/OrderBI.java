package edu.univas.si4.bi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.univas.si4.dao.ConnectionFactory;
import edu.univas.si4.dao.DAOException;
import edu.univas.si4.dao.ItemDAO;
import edu.univas.si4.dao.OrderDAO;
import edu.univas.si4.dao.ProductDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Item;
import edu.univas.si4.entity.Pedido;
import edu.univas.si4.entity.Product;

public class OrderBI {
	
	public static void createOrder(Cliente client, ArrayList<Item> items) throws OrderException {
		try {
			// Criar a conexão com o banco
			Connection connection = ConnectionFactory.createConnection();

			// Iniciar a transação com setAutoCommit(false)
			connection.setAutoCommit(false);
			
			// Inserir o Pedido
			OrderDAO orderDAO = new OrderDAO(connection);

			Pedido order = new Pedido();
			order.setCodCliente(client.getCod());
			order.setData(new Date());
			
			orderDAO.insert(order); // O código do pedido foi atribuído dentro do insert

			// Foreach nos Itens, inserindo cada um dos itens
			ItemDAO itemDAO = new ItemDAO(connection);
			ProductDAO productDAO = new ProductDAO(connection);
			
			for (Item item : items) {
				Product product = productDAO.findForUpdate(item.getProductCode());
				
				if(product != null && product.getBalance() >= item.getQuantity()) {
					item.setOrderCode(order.getCod());
					itemDAO.insert(item);
					
					product.setBalance(product.getBalance() - item.getQuantity());
					productDAO.update(product);
				} else {
					throw new OrderException(product, item.getQuantity());
				}
			}
			
			// Commit
			connection.commit();
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
