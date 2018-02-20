package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Erstellen extends JDialog {

	private static final long serialVersionUID = 520428724484733599L;
	private JLabel title = new JLabel("Erstellen eigener Surveys oder Quizze");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
	private JButton qu = new JButton("Quizze");
	private JButton su = new JButton("Surveys");
	private JButton back = new JButton("Zurück");
	private JPanel header = new JPanel();

	public Erstellen() {
		
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.CENTER);
		header.add(title);
		add(header, BorderLayout.NORTH);
		buttonPanel.add(back);
		buttonPanel.add(su);
		buttonPanel.add(qu);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(400, 400);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MainView back = new MainView();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		qu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EQuiz launcher = new EQuiz();
				launcher.setVisible(true);
				setVisible(false);
				
			}
		});
		
	}

	public static void main(String[] args) {
		
		Erstellen launcher = new Erstellen();
		launcher.setVisible(true);
	
	}

}
