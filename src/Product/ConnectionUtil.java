package Product;

import java.sql.*;

public class ConnectionUtil {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
		return MySQLConnectionUtil.getMySQLConnection();
	}
}
