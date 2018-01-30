package javaSurvey;

import java.awt.*;
import javax.swing.*;

public class JavaSurvey extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 420428732984733599L;
	private JTextField user = new JTextField("Username");
	private JPasswordField pass = new JPasswordField("Password");
	private JButton login = new JButton("Login");
	
	public JavaSurvey() {
		
		setLayout(new BorderLayout());
		add(user, BorderLayout.NORTH);
		add(pass, BorderLayout.CENTER);
		add(login, BorderLayout.SOUTH);		
		setSize(200, 100);
		
	}
	
	
	public static void main(String[] args) {
		
		JavaSurvey launcher = new JavaSurvey();
		launcher.setVisible(true);
		
	}
	
}
