package Product;

import java.sql.*;

public class MySQLConnectionUtil {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		
		String host = "localhost";
		String dbName = "db_stm";
		String username = "root";
		String password = "";
		
		return getMySQLConnection(host, dbName, username, password);
	}

	public static Connection getMySQLConnection(String host, String dbName, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String conUrl = "jdbc:mysql://" + host + ":3306/" + dbName;
		Connection connection = DriverManager.getConnection(conUrl, username, password);
		return connection;
	}
}
