package edu.univas.si4.bi;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.univas.si4.dao.ItemDAO;
import edu.univas.si4.dao.PedidoDAO;
import edu.univas.si4.dao.ProdutoDAO;
import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Item;
import edu.univas.si4.entity.Pedido;
import edu.univas.si4.entity.Produto;

public class OrderBI {
	
	public static void createOrder(Cliente cliente, ArrayList<Item> items) throws OrderException {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("loja");
		
		EntityManager entityManager = factory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// Inserir o Pedido
			PedidoDAO pedidoDAO = new PedidoDAO(entityManager);

			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setData(new Date());
			
			pedidoDAO.insert(pedido);
			
			System.out.println("Pedido de número " + pedido.getCod() + " criado");

			// Foreach nos Itens, inserindo cada um dos itens
			ItemDAO itemDAO = new ItemDAO(entityManager);
			ProdutoDAO productDAO = new ProdutoDAO(entityManager);
			
			for (Item item : items) {
				Produto product = item.getProduto();
				
				if(product.getSaldo() >= item.getQuantidade()) {
					item.setPedido(pedido);
					itemDAO.insert(item);
					
					product.setSaldo(product.getSaldo() - item.getQuantidade());
					productDAO.update(product);
				} else {
					throw new OrderException(product, item.getQuantidade());
				}
			}
			
			// Commit
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
}
