package edu.univas.si4.mvc;

import java.util.ArrayList;

import edu.univas.si4.dao.DAOException;
import edu.univas.si4.dao.ProductDAO;
import edu.univas.si4.entity.Product;

public class ProductController {
	private ProductDAO productDAO;
	
	public ProductController() throws DAOException {
		productDAO = new ProductDAO();
	}

	public ArrayList<Product> getProducts() {
		
		return productDAO.findAll();
	}
}
