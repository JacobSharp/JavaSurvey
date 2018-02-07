package javaSurvey;

import java.awt.*;
import javax.swing.*;

public class LoginJPanel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 120428732984733599L;
	private JTextArea username = new JTextArea("Username");
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

	}

	public static void main(String[] args) {

		LoginJPanel launcher = new LoginJPanel();
		launcher.setVisible(true);

	}

}
