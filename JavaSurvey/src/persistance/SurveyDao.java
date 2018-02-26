package persistance;

import java.util.List;

import model.Quiz;
import model.Survey;

public interface SurveyDao {

	public abstract List<Survey> findAllSurveys();

	public abstract List<Quiz> findAllQuizzes();

	public Survey findAllSurveyQuestions(Survey survey);

}
