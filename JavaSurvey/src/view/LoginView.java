package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controller.UserController;
import model.Survey;
import model.User;
import persistance.SurveyJDBCDao;

public class LoginView extends JDialog {                                                                          


	private static final long serialVersionUID = 120428732984733599L;
	private JTextField username = new JTextField("Username", 20);
	private JPasswordField pass = new JPasswordField("Password");
	private JButton login = new JButton("Login");
	private JButton regist = new JButton("Registrieren");
	private JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
	public boolean loginSuccess = false;

	public void setLoginSuccess(boolean i) {
		this.loginSuccess = i;
	}
	
	public LoginView() {

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
				user.setLookAndFeel(ColorType.WHITE);
				UserController.getController().addUser(user);
			}
		});
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean loginSuccessful = UserController.getController().verifyLogin(username.getText(), new String(pass.getPassword()));
				setLoginSuccess(loginSuccessful);
				System.out.println("login successful? " + loginSuccess);
				if (loginSuccess == true) {
					MainView main = new MainView();
					
					main.setVisible(true);
					SurveyJDBCDao surveyTest = new SurveyJDBCDao();
					List<Survey> surveyList = surveyTest.findAllSurveys();
					main.setS1Text(surveyList.get(0).getSurveyTitle());
					setVisible(false);
				}
				
			}
		});

	}

	public static void main(String[] args) {

		LoginView launcher = new LoginView();

		launcher.setVisible(true);

	}

}
