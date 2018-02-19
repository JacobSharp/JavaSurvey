package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CompletedSurvey;


public class CompletedSurveyJDBCDao implements CompletedSurveyDao{

	public int insertCompletedSurvey(CompletedSurvey completedSurvey) {
		String sql = "insert into javasurveys.user (username, password, spielpunkte, lookAndFeel) values (?, ?, ?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newId = 0;

		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, completedSurvey.getUser_id());
			ps.setInt(2, completedSurvey.getSurvey_id());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newId = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while saving survey data of yours.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("We are sorry. Technical error occurred. Please try again later.", e);
			}
		}
		return newId;

	}

	
}
