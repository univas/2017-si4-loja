package edu.univas.si4.bi;

import edu.univas.si4.entity.Product;

public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;
	private Product product;
	
	private int quantity;
	
	public OrderException(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public OrderException() {
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
