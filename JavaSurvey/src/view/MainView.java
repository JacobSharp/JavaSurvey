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



public class MainView extends JDialog {
	
	private static final long serialVersionUID = 520428732984733599L;
	private JLabel title = new JLabel("Surveys");
	private JLabel aufzaehlung = new JLabel("Beispiel");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
	private JButton pro = new JButton("Profil");
	private JButton ers = new JButton("Erstellen");
	private JTextField leer = new JTextField();
	private JPanel header = new JPanel();
	
	public MainView() {
		
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.LEFT);
		aufzaehlung.setHorizontalAlignment(JLabel.LEFT);
		header.add(title);
		header.add(aufzaehlung);
		add(header, BorderLayout.NORTH);
		buttonPanel.add(pro);
		buttonPanel.add(leer);
		leer.setEditable(false);
		buttonPanel.add(ers);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(400, 400);
		
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

	}

	public static void main(String[] args) {
		
		MainView launcher = new MainView();
		launcher.setVisible(true);

	}

}
