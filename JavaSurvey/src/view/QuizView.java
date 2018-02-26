package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setTitle("Quiz");

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QuizView ok = new QuizView();
				ok.setVisible(true);
				setVisible(false);

			}
		});

	}

	public static void main(String[] args) {

		QuizView launcher = new QuizView();
		launcher.setVisible(true);

	}

}
