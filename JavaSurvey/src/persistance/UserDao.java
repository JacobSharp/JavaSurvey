package persistance;

import model.User;

public interface UserDao {
	  public abstract int insertUser(User user);
	  public abstract User findUserByUsername(String username); 

}