package controller;

import model.Quiz;
import model.Survey;
import persistance.SurveyDao;
import persistance.SurveyJDBCDao;

public class QuizController {

	// singleton
	private static final QuizController CONTROLLER = new QuizController();
	private Quiz currentQuiz = null;
	private int currentQuizQuestion;

	private QuizController() {
	}

	public static QuizController getController() {
		return QuizController.CONTROLLER;
	}
	// end singleton

	private SurveyDao surveyDao = new SurveyJDBCDao();

	public void setCurrentQuiz(Quiz survey) {
		this.currentQuiz = surveyDao.findAllQuizQuestions(survey);
	}
	
	public String getNextQuestion() {
		if (this.currentQuiz.getFragen().size() > currentQuizQuestion) {
			return this.currentQuiz.getFragen().get(currentQuizQuestion++);
		}
		return null;
	}
	
	public String getNextAntwort() {
		if (this.currentQuiz.getAntwort().size() > currentQuizQuestion) {
			return this.currentQuiz.getAntwort().get(currentQuizQuestion++);
		}
		return null;
	}

	public Survey getCurrentQuiz() {
		return currentQuiz;
	}
	
}