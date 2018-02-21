package persistance;

import java.util.List;

import model.Survey;

public interface SurveyDao {

	public abstract List<Survey> findAllSurveys();

}
