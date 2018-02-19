package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Profil extends JDialog {
	
	private static final long serialVersionUID = 420428732984733599L;
	private JLabel title = new JLabel("Profil");
	private JLabel aufzaehlung = new JLabel("Beispiel");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
	private JButton pro = new JButton("Zurück");
	private JTextField leer = new JTextField();
	private JPanel header = new JPanel();
	
	public Profil() {
		
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.LEFT);
		aufzaehlung.setHorizontalAlignment(JLabel.LEFT);
		header.add(title);
		header.add(aufzaehlung);
		add(header, BorderLayout.NORTH);
		buttonPanel.add(pro);
		buttonPanel.add(leer);
		buttonPanel.add(leer);
		leer.setEditable(false);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(400, 400);

	}

	public static void main(String[] args) {
		
		Profil launcher = new Profil();
		launcher.setVisible(true);

	}

}
