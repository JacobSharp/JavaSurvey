package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.QuizController;
import controller.UserController;
import model.User;
import persistance.CompletedSurveyJDBCDao;

public class QuizView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextField eingabe = new JTextField("schreiben...");
	private JButton ok = new JButton("OK");
	private JLabel text = new JLabel("Beispiel Text");
	private User user = UserController.getController().getUser();
	private QuizController QUIZ_CONTROLLER = QuizController.getController();

	private void addUserPoints() {
		user.setSpielpunkte(user.getSpielpunkte() + 1);
	}

	public QuizView(String question) {

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

				String question = QUIZ_CONTROLLER.getNextQuestion();
				String antwort = QUIZ_CONTROLLER.getNextAntwort();

				if (question != null) {
					if (eingabe.toString() == antwort) {
						QuizView next = new QuizView(question);
						next.setVisible(true);
						setVisible(false);
					} else {
						
					}}
					else {
						addUserPoints();
						CompletedSurveyJDBCDao comp = new CompletedSurveyJDBCDao();
						comp.insertCompletedSurvey(user.getId(),
								QuizController.getController().getCurrentQuiz().getId());
						MainView main = new MainView();
						setVisible(false);
						main.setVisible(true);
					}
					
					}
					
			
		});

	}

}
