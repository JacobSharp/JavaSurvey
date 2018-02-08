package javaSurvey;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginJPanel extends JDialog {

	/**
	 * ehemalige Name: A1
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextField username = new JTextField("Username", 20);
	private JPasswordField pass = new JPasswordField("Password");
	private JButton login = new JButton("Login");
	private JButton regist = new JButton("Registrieren");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));

	public LoginJPanel() {

		setLayout(new BorderLayout());
		add(username, BorderLayout.NORTH);
		add(pass, BorderLayout.CENTER);
		
		buttonPanel.add(login);
		buttonPanel.add(regist);
		add(buttonPanel, BorderLayout.SOUTH);
		setSize(230, 100);
		
		regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUsername(username.getText());
				user.setPassword(new String(pass.getPassword()));
				user.setSpielpunkte(0);
				user.setLookAndFeel(0);
				JavaSurveyController.getController().addUser(user);
			}
		});
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean loginSuccess = JavaSurveyController.getController().verifyLogin(username.getText(), new String(pass.getPassword()));
				System.out.println("login successful? " + loginSuccess);
				if (loginSuccess == true) {
					// Übersichtsfenster
				}
				
			}
		});

	}

	public static void main(String[] args) {

		LoginJPanel launcher = new LoginJPanel();
		launcher.setVisible(true);

	}

}
