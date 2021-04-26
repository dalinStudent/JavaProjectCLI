package Product;

import java.sql.*;

public class UserManager extends Login {
	static Connection connection = null;
	static ResultSet result = null;
	static PreparedStatement pstmst;
	public void addUser(String firstName, String lastName, String province, String phone, String email, String password) throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "INSERT INTO tbl_users (first_name,last_name,email,password,phone,province) VALUES(?,?,?,?,?,?)";
		    pstmst = connection.prepareStatement(sql);
		    pstmst.setString(1, firstName);
		    pstmst.setString(2, lastName);
		    pstmst.setString(3, email);
		    pstmst.setString(4, password);
		    pstmst.setString(5, phone);
		    pstmst.setString(6, province);
			 int data = pstmst.executeUpdate();
		      if(data!=0){
		        System.out.println("\n>> Add user successfully <<"); 
		        login();
		      }
		      else{
		        System.out.println("\\n>> Add user unsuccessfull <<");
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
