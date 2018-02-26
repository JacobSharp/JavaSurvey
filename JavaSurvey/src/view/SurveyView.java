package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SurveyController;
import controller.UserController;
import model.User;
import persistance.CompletedSurveyJDBCDao;

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
	private SurveyController SURVEY_CONTROLLER = SurveyController.getController();

	private void addUserPoints() {
		user.setSpielpunkte(user.getSpielpunkte() + 1);
	}

	public SurveyView(String question) {

		setLayout(new BorderLayout());
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText(question);
		add(text, BorderLayout.NORTH);
		buttonPanel.add(ja);
		buttonPanel.add(nein);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(200, 100);
		setTitle("Survey");

		ja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String question = SURVEY_CONTROLLER.getNextQuestion();

				if (question != null) {
					SurveyView ja = new SurveyView(question);
					ja.setVisible(true);
					setVisible(false);
				} else {
					addUserPoints();
					CompletedSurveyJDBCDao comp = new CompletedSurveyJDBCDao();
					comp.insertCompletedSurvey(user.getId(),
							SurveyController.getController().getCurrentSurvey().getId());
					MainView main = new MainView();
					setVisible(false);
					main.setVisible(true);
				}

			}
		});

		nein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String question = SURVEY_CONTROLLER.getNextQuestion();

				if (question != null) {
					SurveyView nein = new SurveyView(question);
					nein.setVisible(true);
					setVisible(false);
				} else {
					addUserPoints();
					CompletedSurveyJDBCDao comp = new CompletedSurveyJDBCDao();
					comp.insertCompletedSurvey(user.getId(),
							SurveyController.getController().getCurrentSurvey().getId());
					MainView main = new MainView();
					setVisible(false);
					main.setVisible(true);
				}

			}
		});

	}
}
