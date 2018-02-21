package controller;

import model.User;
import persistance.UserDao;
import persistance.UserJDBCDao;
import view.ColorType;

public class UserController {

	// singleton
	private static final UserController CONTROLLER = new UserController();
	private ColorType userBackgroundColor = null;
	private User user = new User();

	private UserController() {
	}

	public static UserController getController() {
		return UserController.CONTROLLER;
	}
	// end singleton

	private UserDao userDao = new UserJDBCDao();

	public void addUser(User user) {
		userDao.insertUser(user);
	}

	public boolean verifyLogin(String username, String password) {
		User user = userDao.findUserByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			this.user = user;
			return true;
		} else {
			return false;
		}
	}
	
	public ColorType getUserBackgroundColor() {
		if (userBackgroundColor == null) {
			ColorType tempUserBackgroundColor = userDao.findUserBackgroundColor(user.getUsername());
			if (tempUserBackgroundColor != null) {
				userBackgroundColor = tempUserBackgroundColor;
			} else {
				userBackgroundColor = ColorType.White;
			}
		}
		return userBackgroundColor;
	}
}
