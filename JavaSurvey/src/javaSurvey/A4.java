package javaSurvey;

import java.awt.*;
import javax.swing.*;

public class A4 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JLabel text = new JLabel("Beispiel Text");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
	private JButton ja = new JButton("Ja");
	private JButton nein = new JButton("Nein");

	public A4() {

		setLayout(new BorderLayout());
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text, BorderLayout.NORTH);
		buttonPanel.add(ja);
		buttonPanel.add(nein);
		add(buttonPanel, BorderLayout.CENTER);
		setSize(200, 100);

	}

	public static void main(String[] args) {

		A4 launcher = new A4();
		launcher.setVisible(true);

	}

}
