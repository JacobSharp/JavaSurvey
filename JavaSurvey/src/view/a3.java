package view;

import java.awt.*;
import javax.swing.*;

public class a3 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextArea text = new JTextArea("Beispiel Text");
	private JButton ja = new JButton("Ja");
	private JButton nein = new JButton("Nein");

	public a3() {

		setLayout(new BorderLayout());
		add(text, BorderLayout.NORTH);
		add(ja, BorderLayout.CENTER);
		add(nein, BorderLayout.EAST);
		setSize(200, 100);

	}

	public static void main(String[] args) {

		a3 launcher = new a3();
		launcher.setVisible(true);

	}

}
