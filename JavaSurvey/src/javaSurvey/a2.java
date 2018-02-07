package javaSurvey;

import java.awt.*;
import javax.swing.*;

public class a2 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextArea eingabe = new JTextArea("schreiben...");
	private JButton ok = new JButton("OK");
	private JTextArea text = new JTextArea("Beispiel Text");

	public a2() {

		setLayout(new BorderLayout());
		add(text, BorderLayout.NORTH);
		add(eingabe, BorderLayout.CENTER);
		add(ok, BorderLayout.EAST);
		setSize(200, 100);

	}

	public static void main(String[] args) {

		a2 launcher = new a2();
		launcher.setVisible(true);

	}

}
