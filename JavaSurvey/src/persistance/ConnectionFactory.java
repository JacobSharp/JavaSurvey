package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private final String dbURL = "jdbc:mysql://localhost:3306/javasurveys?autoReconnect=true&useSSL=false";
	private final String dbUser = "root";
	private final String dbPwd = "1234";

	private Connection connection = null;

	private ConnectionFactory() {
	}

	public Connection getConnection() {

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(dbURL, dbUser, dbPwd);
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
		return connection;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
}
