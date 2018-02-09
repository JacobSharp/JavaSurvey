package controller;

import javaSurvey.User;
import persistance.UserDao;
import persistance.UserJDBCDao;

public class JavaSurveyController {

	// singleton
	private static final JavaSurveyController CONTROLLER = new JavaSurveyController();

	private JavaSurveyController() {
	}

	public static JavaSurveyController getController() {
		return JavaSurveyController.CONTROLLER;
	}
	// end singleton

	private UserDao userDao = new UserJDBCDao();

	public void addUser(User user) {
		userDao.insertUser(user);
	}

	public boolean verifyLogin(String username, String password) {
		User user = userDao.findUserByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
