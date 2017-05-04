package edu.univas.si4.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel visiblePanel;
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		visiblePanel = new ProductPanel();
		add(visiblePanel);
	}
}
