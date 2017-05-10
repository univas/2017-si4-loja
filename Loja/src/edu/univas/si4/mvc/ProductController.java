package edu.univas.si4.mvc;

import java.util.List;

import edu.univas.si4.dao.DAOException;
import edu.univas.si4.dao.ProdutoDAO;
import edu.univas.si4.entity.Produto;

public class ProductController {
	private ProdutoDAO produtoDAO;
	
	public ProductController() throws DAOException {
		produtoDAO = new ProdutoDAO();
	}

	public List<Produto> getProducts() {
		
		return produtoDAO.findAll();
	}
}
