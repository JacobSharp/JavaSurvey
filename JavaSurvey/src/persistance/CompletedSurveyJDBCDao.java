package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CompletedSurvey;

public class CompletedSurveyJDBCDao implements CompletedSurveyDao {

	public void insertCompletedSurvey(int user_id, int survey_id) {
		String sql = "insert into javasurveys.completedSurvey (user_id, survey_id) values (?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, user_id);
			ps.setInt(2, survey_id);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
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

	}

	public void findAllCompletedSurveys(int user_id) {
		String sql = "select * from javasurveys.completedsurvey where user_id = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				CompletedSurvey comp = new CompletedSurvey();
				comp.setUser_id(rs.getInt("user_id"));
				comp.setSurvey_id(rs.getInt("survey_id"));

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
		// TODO return completed surveys for checking
	}

}
