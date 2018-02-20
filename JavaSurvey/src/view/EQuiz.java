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
import javax.swing.JTextField;

public class EQuiz extends JDialog {

	private static final long serialVersionUID = 534428732984733599L;
	private JLabel title = new JLabel("Erstelle dein eigens Quiz");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
	private JButton back = new JButton("Zurück");
	private JButton save = new JButton("Speichern");
	private JTextField in = new JTextField("Hier deine Frage hinschreiben");
	private JTextField ant = new JTextField("Hier die Antwort hinschreiben");
	private JPanel eingaben = new JPanel();
	
	public EQuiz() {

		eingaben.setLayout(new BoxLayout(eingaben, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title, BorderLayout.NORTH);
		eingaben.add(in);
		eingaben.add(ant);
		add(eingaben, BorderLayout.CENTER);
		buttonPanel.add(back);
		buttonPanel.add(save);
		add(buttonPanel, BorderLayout.SOUTH);
		add(in, BorderLayout.CENTER);
		add(ant, BorderLayout.CENTER);
		setSize(400, 400);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Erstellen launcher = new Erstellen();
				launcher.setVisible(true);
				setVisible(false);
				
			}
		});
		
	}

	public static void main(String[] args) {
		
		EQuiz launcher = new EQuiz();
		launcher.setVisible(true);

	}

}
