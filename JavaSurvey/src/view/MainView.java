package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import persistance.SurveyJDBCDao;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Survey;

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

	public MainView() {
		setSize(400, 400);
		setLayout(new BorderLayout());

		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		surveyTitlePanel.add(surveyTitle);
		s1ButtonPanel.add(s1);
		s2ButtonPanel.add(s2);
		s3ButtonPanel.add(s3);
		northButtonPanel.add(s1ButtonPanel);
		northButtonPanel.add(s2ButtonPanel);
		northButtonPanel.add(s3ButtonPanel);
		northPanel.add(surveyTitlePanel);
		northPanel.add(northButtonPanel);
		add(northPanel, BorderLayout.NORTH);

		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		quizTitlePanel.add(quizTitle);
		q1ButtonPanel.add(q1);
		q2ButtonPanel.add(q2);
		q3ButtonPanel.add(q3);
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

				Profil profil = new Profil();
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

				LookAndFeel launcher = new LookAndFeel();
				launcher.setVisible(true);
				setVisible(false);

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

	public static void main(String[] args) {

		MainView launcher = new MainView();
		
		
		launcher.setVisible(true);

	}

}
