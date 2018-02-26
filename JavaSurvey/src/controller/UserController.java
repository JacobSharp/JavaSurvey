package controller;

import java.awt.Color;

import model.User;
import persistance.UserDao;
import persistance.UserJDBCDao;
import view.ColorType;

public class UserController {

	// singleton
	private static final UserController CONTROLLER = new UserController();
	private ColorType userBackgroundColor = null;
	private User user = null;

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
		setUser(userDao.findUserByUsername(username));

		if (getUser() != null && getUser().getPassword().equals(password)) {
			getUserBackgroundColor();
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
				userBackgroundColor = ColorType.WHITE;
			}
		}
		return userBackgroundColor;
	}

	public void changeUserBackgroundColor(Color color) { // TODO Color zum ColorType konvertieren (via ColorType
															// manuelle helper-Klasse)
		// user.setLookAndFeel(color);
		userDao.updateUserBackgroundColor(user);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
