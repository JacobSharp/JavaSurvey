package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.UserController;
import model.Quiz;
import model.Survey;
import model.User;
import persistance.SurveyJDBCDao;

public class MainView extends JDialog {

	private static final long serialVersionUID = 520428732984733599L;

	private JPanel northPanel = new JPanel();
	private JPanel surveyTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JLabel surveyTitle = new JLabel("Surveys");
	private JPanel northButtonPanel = new JPanel(new GridLayout(1, 3));
	private JPanel s1ButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton s1 = new JButton("Survey 1");
	private JPanel s2ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JButton s2 = new JButton("Survey 2");
	private JPanel s3ButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JButton s3 = new JButton("Survey 3");

	private JPanel centerPanel = new JPanel();
	private JPanel quizTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JLabel quizTitle = new JLabel("Quizze");
	private JPanel centerButtonPanel = new JPanel(new GridLayout(1, 3));
	private JPanel q1ButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JButton q1 = new JButton("Quiz 1");
	private JPanel q2ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JButton q2 = new JButton("Quiz 2");
	private JPanel q3ButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JButton q3 = new JButton("Quiz 3");

	private JPanel southPanel = new JPanel(new GridLayout(1, 3));
	private JButton pro = new JButton("Profil");
	private JButton ers = new JButton("Erstellen");
	private JButton laf = new JButton("LookAndFeel");
	private User user = UserController.getController().getUser();

	private void subtractUserPoints() {
		user.setSpielpunkte(user.getSpielpunkte() - 1);
	}

	public MainView() {
		setSize(400, 400);
		setLayout(new BorderLayout());
		setTitle("Main");
		SurveyJDBCDao surveyImport = new SurveyJDBCDao();
		List<Survey> surveyList = surveyImport.findAllSurveys();
		List<Quiz> quizList = surveyImport.findAllQuizzes();
		setS1Text(surveyList.get(0).getSurveyTitle());
		int surveyCount = surveyList.size();
		int quizCount = quizList.size();

		try {
			if (surveyList.get(0) != null) {
				setS1Text(surveyList.get(0).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			if (surveyList.get(1) != null) {
				setS2Text(surveyList.get(1).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			if (surveyList.get(2) != null) {
				setS3Text(surveyList.get(2).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			if (quizList.get(0) != null) {
				setQ1Text(quizList.get(0).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			if (quizList.get(1) != null) {
				setQ2Text(quizList.get(1).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			if (quizList.get(2) != null) {
				setQ3Text(quizList.get(2).getSurveyTitle());
			}
		} catch (IndexOutOfBoundsException e) {

		}

		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		surveyTitlePanel.add(surveyTitle);
		if (surveyCount >= 1) {
			s1ButtonPanel.add(s1);
		}
		if (surveyCount >= 2) {
			s2ButtonPanel.add(s2);
		}
		if (surveyCount >= 3) {
			s3ButtonPanel.add(s3);
		}
		northButtonPanel.add(s1ButtonPanel);
		northButtonPanel.add(s2ButtonPanel);
		northButtonPanel.add(s3ButtonPanel);
		northPanel.add(surveyTitlePanel);
		northPanel.add(northButtonPanel);
		add(northPanel, BorderLayout.NORTH);

		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		quizTitlePanel.add(quizTitle);
		if (quizCount >= 1) {
			q1ButtonPanel.add(q1);
		}
		if (quizCount >= 2) {
			q2ButtonPanel.add(q2);
		}
		if (quizCount >= 3) {
			q3ButtonPanel.add(q3);
		}
		centerButtonPanel.add(q1ButtonPanel);
		centerButtonPanel.add(q2ButtonPanel);
		centerButtonPanel.add(q3ButtonPanel);
		centerPanel.add(quizTitlePanel);
		centerPanel.add(centerButtonPanel);
		add(centerPanel, BorderLayout.CENTER);

		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		southPanel.add(pro);
		southPanel.add(laf);
		southPanel.add(ers);
		add(southPanel, BorderLayout.SOUTH);

		pro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ProfilView profil = new ProfilView();
				profil.setVisible(true);
				setVisible(false);

			}
		});

		ers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Erstellen erstellen = new Erstellen();
				erstellen.setVisible(true);
				setVisible(false);

			}
		});

		laf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (user.getSpielpunkte() != 0) {
					subtractUserPoints();
					LookAndFeel launcher = new LookAndFeel();
					launcher.setVisible(true);
					setVisible(false);

				}
				else {
					System.out.println("Du hast keine Spielpünkte. Es kostet einen Punkt um den Look and Feel zu ändern.");
				}
				
			}
		});

		q1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QuizView launche = new QuizView();
				launche.setVisible(true);
				setVisible(false);

			}
		});

		s1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SurveyView survey = new SurveyView();

			}

		});

	}

	public void setS1Text(String text) {
		this.s1.setText(text);
	}

	public void setS2Text(String text) {
		this.s2.setText(text);
	}

	public void setS3Text(String text) {
		this.s3.setText(text);
	}

	public void setQ1Text(String text) {
		this.q1.setText(text);
	}

	public void setQ2Text(String text) {
		this.q2.setText(text);
	}

	public void setQ3Text(String text) {
		this.q3.setText(text);
	}

	public static void main(String[] args) {

		MainView launcher = new MainView();

		launcher.setVisible(true);

	}

}
