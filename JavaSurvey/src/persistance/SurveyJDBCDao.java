package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Survey;

public class SurveyJDBCDao implements SurveyDao{

	public Survey findSurvey() {
		String sql = "select * from javasurveys.survey";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Survey survey = null;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				survey = new Survey();
				survey.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while searching user with username " + survey, e);
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
		return survey;
	}

	public static void main(String[] args) {
		SurveyJDBCDao test = new SurveyJDBCDao();
		test.findSurvey();
	}
}
