package edu.univas.si4.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.univas.si4.entity.Cliente;
import edu.univas.si4.entity.Pedido;

public class PedidoDAO extends GenericDAO<Pedido, Integer> {

	public PedidoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PedidoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Pedido> findByClient(Cliente cliente) {
		
		String hql = "	SELECT "
				+ "			p "
				+ "		FROM "
				+ "			Pedido p "
				+ "		WHERE "
				+ "			p.cliente = :cliente";
		
		Query query = entityManager.createQuery(hql);
		query.setParameter("cliente", cliente);
		
		return (ArrayList<Pedido>) query.getResultList();
	}
	
	public Pedido findLastByClient(Cliente cliente) {
		
		// Usando o createNamedQuery para usar uma query definida na Entidade
		Query query = entityManager.createNamedQuery("Pedido.findLastByClient");
		query.setParameter("cliente", cliente);

		query.setMaxResults(1); // Limitando em um objeto retornado
		
		return (Pedido) query.getSingleResult(); // Pegando o objeto resultante
	}
}
