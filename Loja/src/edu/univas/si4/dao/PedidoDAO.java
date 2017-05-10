package edu.univas.si4.dao;

import javax.persistence.EntityManager;

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

}
