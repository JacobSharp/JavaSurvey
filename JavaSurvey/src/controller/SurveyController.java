package controller;

import model.Survey;
import persistance.SurveyDao;
import persistance.SurveyJDBCDao;

public class SurveyController {

	// singleton
	private static final SurveyController CONTROLLER = new SurveyController();
	private Survey currentSurvey = null;
	private int currentSurveyQuestion;

	private SurveyController() {
	}

	public static SurveyController getController() {
		return SurveyController.CONTROLLER;
	}
	// end singleton

	private SurveyDao surveyDao = new SurveyJDBCDao();

	public void setCurrentSurvey(Survey survey) {
		this.currentSurvey = surveyDao.findAllSurveyQuestions(survey);
	}

	public String getNextQuestion() {
		if (this.currentSurvey.getFragen().size() > currentSurveyQuestion) {
			return this.currentSurvey.getFragen().get(currentSurveyQuestion++);
		}
		return null;
	}

	public Survey getCurrentSurvey() {
		return currentSurvey;
	}

}
