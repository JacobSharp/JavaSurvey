package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Survey;

public class SurveyJDBCDao implements SurveyDao {

	public List<Survey> findAllSurveys() {
		String sql = "select * from javasurveys.survey";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Survey> surveyList = new ArrayList<Survey>();

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Survey survey = new Survey();
				survey.setId(rs.getInt("id"));
				survey.setQuiz(rs.getBoolean("isQuiz"));
				survey.setUser_id(rs.getInt("user_id"));
				survey.setSurveyTitle(rs.getString("survey_name"));
				surveyList.add(survey);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("We are sorry. A technical error occurred. Please try again later.", e);
			}
		}
		return surveyList;
	}

	public static void main(String[] args) {
		SurveyJDBCDao test = new SurveyJDBCDao();
		List<Survey> surveys = test.findAllSurveys();
		for(Survey survey : surveys) {
			System.out.println(survey.getId() + " " + survey.isQuiz() + " " + survey.getUser_id() + " " + survey.getSurveyTitle());
			
		}
	}
}
