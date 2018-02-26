package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import javax.swing.*;
import controller.UserController;

public class SurveyView extends JDialog {

	/**
	 * ehemalige Name: A4
	 */

	private static final long serialVersionUID = 120428732984733599L;
	private JLabel text = new JLabel("Beispiel Text");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
	private JButton ja = new JButton("Ja");
	private JButton nein = new JButton("Nein");
	private User user = UserController.getController().getUser();

	private void addUserPoints() {
		user.setSpielpunkte(user.getSpielpunkte() + 1);
	}

	public SurveyView() {

		setLayout(new BorderLayout());
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text, BorderLayout.NORTH);
		buttonPanel.add(ja);
		buttonPanel.add(nein);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(200, 100);
		setTitle("Survey");

		ja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SurveyView ja = new SurveyView();
				ja.setVisible(true);
				setVisible(false);

			}
		});

		nein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SurveyView nein = new SurveyView();
				nein.setVisible(true);
				setVisible(false);

			}
		});

	}

	public static void main(String[] args) {

		SurveyView launcher = new SurveyView();
		launcher.setVisible(true);

	}

}
