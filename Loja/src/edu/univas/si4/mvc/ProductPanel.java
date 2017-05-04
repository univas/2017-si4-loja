package edu.univas.si4.mvc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.univas.si4.dao.DAOException;
import edu.univas.si4.entity.Product;

public class ProductPanel extends JPanel {
	private ProductController controller;
	
	private JTextField fieldProduct;
	private DefaultTableModel tableModel;
	
	public ProductPanel() {
		try {
			controller = new ProductController();

			setLayout(new GridBagLayout());
			
			addNameField();
			addTable();

		} catch (DAOException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(
					this, 
					"Falha na conexão com o banco", 
					"Cadastro de Produto", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void addNameField() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 5, 5);
		
		JLabel labelProduct = new JLabel("Produto:");
		add(labelProduct, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(15, 0, 5, 15);

		fieldProduct = new JTextField(20);

		Date now = new Date();
		String formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(now);
		fieldProduct.setText(formatedDate);
		
		add(fieldProduct, gbc);
	}

	private void addTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] {"Código", "Nome", "Saldo"});
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 15, 15, 15);
		
		add(scrollPane, gbc);
		
		updateTable();
	}

	private void updateTable() {
		ArrayList<Product> products = controller.getProducts();	
		
		tableModel.setRowCount(0); // Reset
		
		for (Product product : products) {
			tableModel.addRow(new String[]  {
				String.valueOf(product.getCode()),
				product.getName(),
				String.valueOf(product.getBalance())
			});
			
		}
	}

}
