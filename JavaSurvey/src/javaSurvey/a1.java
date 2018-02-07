package javaSurvey;

import java.awt.*;
import javax.swing.*;

public class a1 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextArea text = new JTextArea("Bla Bla");
	private JButton login = new JButton("Login");
	private JButton regist = new JButton("Registrieren");

	public a1() {

		setLayout(new BorderLayout());
		add(text, BorderLayout.NORTH);
		add(regist, BorderLayout.CENTER);
		add(login, BorderLayout.SOUTH);
		setSize(200, 100);

	}

	public static void main(String[] args) {

		a1 launcher = new a1();
		launcher.setVisible(true);

	}

}
