package edu.univas.si4.bi;

import edu.univas.si4.entity.Produto;

public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;
	private Produto product;
	
	private int quantity;
	
	public OrderException(Produto product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public OrderException() {
		// TODO Auto-generated constructor stub
	}

	public Produto getProduct() {
		return product;
	}

	public void setProduct(Produto product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
