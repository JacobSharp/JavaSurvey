package persistance;

import model.User;
import view.ColorType;

public interface UserDao {
	public abstract int insertUser(User user);

	public abstract User findUserByUsername(String username);

	public abstract ColorType findUserBackgroundColor(String username);
	
	public void updateUserBackgroundColor(User user);

}
