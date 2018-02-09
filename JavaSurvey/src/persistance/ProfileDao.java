package persistance;

import javaSurvey.Profile;

public interface ProfileDao {
		
	public abstract Profile findProfileByUser(int id);
	
}
