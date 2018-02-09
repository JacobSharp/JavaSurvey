package javaSurvey;

import javax.swing.JFrame;

import view.LoginView;

public class JavaSurvey extends JFrame {


	private static final long serialVersionUID = 1L;

	public JavaSurvey() {

		

	}

	public static void main(String[] args) {

		LoginView login = new LoginView();
		JavaSurvey javaSurvey = new JavaSurvey();  
		javaSurvey.add(login);
		javaSurvey.setVisible(true);

	}

}












