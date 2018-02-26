package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Profile;
import view.ColorType;

public class ProfileJDBCDao implements ProfileDao {

	@Override
	public Profile findProfileByUser(int id) {
		String sql = "select * from javasurveys.profile where user_id = ?";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Profile profile = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				profile = new Profile();
				profile.setId(rs.getInt("id"));
				profile.setName(rs.getString("name"));
				profile.setGeburtsdatum(rs.getDate("geburtsdatum"));
				profile.setProfilBildLink(rs.getString("profilBildLink"));
				profile.setUser_id(rs.getInt("user_id"));
				break;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error occurred while searching for your profile: ", e);
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
		return profile;
	}

}
