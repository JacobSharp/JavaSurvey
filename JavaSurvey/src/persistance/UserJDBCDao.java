package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserJDBCDao implements UserDao {

	@Override
	public int insertUser(User user) {
		String sql = "insert into javasurveys.user (username, password, spielpunkte, lookAndFeel) values (?, ?, ?, ?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newId = 0;

		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getSpielpunkte());
			ps.setInt(4, user.getLookAndFeel());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newId = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while saving user with username " + user.getUsername(), e);
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

	@Override
	public User findUserByUsername(String username) {
		String sql = "select * from javasurveys.user where username = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLookAndFeel(rs.getInt("lookAndFeel"));
				user.setPassword(rs.getString("password"));
				user.setSpielpunkte(rs.getInt("spielpunkte"));
				user.setUsername(rs.getString("username"));
				break;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while searching user with username " + username, e);
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
		return user;
	}

}
