package javaSurvey;

import javax.swing.JFrame;

import view.*;

public class JavaSurvey extends JFrame {

	private static final long serialVersionUID = 1L;

	public JavaSurvey() {

	}

	public static void main(String[] args) {

		LoginView login = new LoginView();
		JavaSurvey javaSurvey = new JavaSurvey();
		javaSurvey.add(login);
		javaSurvey.setVisible(true);
		if (login.loginSuccess == true) {
			MainView mainView = new MainView();
			javaSurvey.setVisible(false);
			javaSurvey.remove(login);
			javaSurvey.add(mainView);
			javaSurvey.setVisible(true);
		}

	}

}
