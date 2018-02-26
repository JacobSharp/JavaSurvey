package javaSurvey;

import javax.swing.JFrame;

import view.*;

public class JavaSurvey extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		LoginView login = new LoginView();
		login.setVisible(true);
		}

	}

