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

import controller.UserController;

public class Profil extends JDialog {

	private static final long serialVersionUID = 420428732984733599L;
	private JLabel title = new JLabel("Profil");

	private JPanel userData = new JPanel(new GridLayout(3, 2));
	private JLabel userId = new JLabel("Id:");
	private JLabel userName = new JLabel("Username:");
	private JLabel spielPunkte = new JLabel("Spielpunkte:");
	private JLabel userIdData = new JLabel();
	private JLabel userNameData = new JLabel();
	private JLabel spielPunkteData = new JLabel();

	private JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
	private JButton back = new JButton("Zurück");
	private JTextField leer = new JTextField();
	private JPanel header = new JPanel();

	public Profil() {

		userIdData.setText(String.valueOf(UserController.getController().getUser().getId()));
		userNameData.setText(UserController.getController().getUser().getUsername());
		spielPunkteData.setText(String.valueOf(UserController.getController().getUser().getSpielpunkte()));

		userData.add(userId);
		userData.add(userIdData);
		userData.add(userName);
		userData.add(userNameData);
		userData.add(spielPunkte);
		userData.add(spielPunkteData);

		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		title.setHorizontalAlignment(JLabel.LEFT);

		header.add(title);
		header.add(userData);
		add(header, BorderLayout.NORTH);
		buttonPanel.add(back);
		buttonPanel.add(leer);
		buttonPanel.add(leer);
		leer.setEditable(false);
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

	}

	public static void main(String[] args) {

		Profil launcher = new Profil();
		launcher.setVisible(true);

	}
}
