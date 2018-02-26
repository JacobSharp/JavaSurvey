package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import view.ColorType;

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
			ps.setString(4, user.getLookAndFeel().toString());
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
				System.out.println("User color: " + rs.getString("lookAndFeel"));
				 user.setLookAndFeel(ColorType.valueOf(rs.getString("lookAndFeel").toUpperCase()));
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

	@Override
	public ColorType findUserBackgroundColor(String username) {
		String sql = "select * from javasurveys.user where username = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ColorType userBackgroundColor = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				String tempUserBackgroundColor = rs.getString("lookAndFeel").toUpperCase();
				System.out.println("BackgroundColor of user \"" + username + "\" is " + tempUserBackgroundColor);
				if (tempUserBackgroundColor != null) {			
					userBackgroundColor = ColorType.valueOf(tempUserBackgroundColor);
				}
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
//		ConnectionFactory.getInstance().closeConnection();
		return userBackgroundColor;
	}
	
	public void updateUserBackgroundColor(User user) {
		System.out.println(user.getLookAndFeel().toString().toLowerCase());
		String sql = "UPDATE user SET lookAndFeel = ? WHERE id = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getLookAndFeel().toString().toLowerCase());
			ps.setInt(2, user.getId());
			rs = ps.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while executing your process", e);
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
		
	}

	@Override
	public void updateUserPoints(User user) {
		String sql = "UPDATE user SET spielpünkte = ? WHERE id = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.getSpielpunkte());
			ps.setInt(2, user.getId());
			rs = ps.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while executing your process", e);
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
	}
}
