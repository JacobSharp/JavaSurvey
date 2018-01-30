package javaSurvey;

public class Survey {

	private String surveyTitle;
	private int id;
	private int user_id;
	private boolean isQuiz;
	private String fragen[];

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean isQuiz() {
		return isQuiz;
	}

	public void setQuiz(boolean isQuiz) {
		this.isQuiz = isQuiz;
	}

	public String[] getFragen() {
		return fragen;
	}

	public void setFragen(String fragen[]) {
		this.fragen = fragen;
	}

}
