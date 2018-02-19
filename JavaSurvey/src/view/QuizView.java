package view;

import java.awt.*;
import javax.swing.*;

public class QuizView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextField eingabe = new JTextField("schreiben...");
	private JButton ok = new JButton("OK");
	private JLabel text = new JLabel("Beispiel Text");

	public QuizView() {

		text.setHorizontalAlignment(JLabel.CENTER);
		setLayout(new BorderLayout());
		add(text, BorderLayout.NORTH);
		add(eingabe, BorderLayout.CENTER);
		add(ok, BorderLayout.EAST);
		setSize(200, 100);

	}

	public static void main(String[] args) {

		QuizView launcher = new QuizView();
		launcher.setVisible(true);

	}

}
