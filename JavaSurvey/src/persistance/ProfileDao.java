package persistance;

import model.Profile;

public interface ProfileDao {
		
	public abstract Profile findProfileByUser(int id);
	
}
