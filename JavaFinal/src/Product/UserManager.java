package Product;

import java.sql.*;
import java.util.*;

public class UserManager extends Login {
	static Connection connection = null;
	static ResultSet result = null;
	static PreparedStatement pstmst;
	public void addUser(User user) throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "INSERT INTO tbl_users (first_name,last_name,email,password,phone,province) VALUES(?,?,?,?,?,?)";
		    pstmst = connection.prepareStatement(sql);
		    pstmst.setString(1, user.getFirstName());
		    pstmst.setString(2, user.getLastName());
		    pstmst.setString(3, user.getEmail());
		    pstmst.setString(4, user.getPassword());
		    pstmst.setString(5, user.getPhone());
		    pstmst.setString(6, user.getProvince());
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
	
	public User findUser(int id) throws ClassNotFoundException { 
		User user = null;
		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "SELECT user_id, first_name, last_name, email, phone, province FROM tbl_users WHERE user_id =" + id;
			pstmst = connection.prepareStatement(sql);
			result = pstmst.executeQuery();
			
			while(result.next()) {
				int idUser = result.getInt(1);
				String firstName = result.getString(2);
				String lastName = result.getString(3);
				String email = result.getString(4);
				String phone = result.getString(5);
				String province = result.getString(6);

				user =  new User(idUser, firstName, lastName, email, phone, province);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
		
	}
    public void updateUser(User user) throws ClassNotFoundException {
    	try {
			connection = ConnectionUtil.getMyConnection();
			String sql = "UPDATE tbl_users SET first_name=?, last_name=?, email=?, password=?, phone=?, province=?  WHERE user_id=?";
			pstmst = connection.prepareStatement(sql);
		    pstmst.setString(1, user.getFirstName());
		    pstmst.setString(2, user.getLastName());
		    pstmst.setString(3, user.getEmail());
		    pstmst.setString(4, user.getPassword());
		    pstmst.setString(5, user.getPhone());
		    pstmst.setString(6, user.getProvince());
		    pstmst.setInt(7, user.getId());
		    int data = pstmst.executeUpdate();
		    if(data!=0){
		    	System.out.println("\n>> Update user successfully <<"); 
		    	login();
		    }
		    else{
		    	System.out.println("\n>> Update user unsuccessfull <<");
		    }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
    public void deleteUser(int id) throws ClassNotFoundException, SQLException {
    	connection = ConnectionUtil.getMyConnection();
    	String sql = "DELETE FROM tbl_users WHERE user_id=" + id;
    	pstmst = connection.prepareStatement(sql);
    	int rowEffect = pstmst.executeUpdate();
    	System.out.println("\n>> Delete user successfully <<");
    	login();
	}
}
