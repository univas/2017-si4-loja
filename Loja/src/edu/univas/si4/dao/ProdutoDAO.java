package edu.univas.si4.dao;

import javax.persistence.EntityManager;

import edu.univas.si4.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer> {

	public ProdutoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
