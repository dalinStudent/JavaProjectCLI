package Product;

import java.sql.*;
import java.util.*;

public class ProductManager {
	static Connection connection = null;
	static Statement insertStatement = null;
	static Statement selectStatement = null;
	static Statement updateStatement = null;
	static Statement deleteStatement = null;
	static ResultSet result;
	static PreparedStatement pstmst;
	public List<Product> getAllProduct() throws ClassNotFoundException {
		List<Product> productList = new ArrayList<Product>();
		try {
			connection = ConnectionUtil.getMyConnection();
			 selectStatement = connection.createStatement();
			 result = selectStatement.executeQuery("SELECT * FROM tbl_products");
				while(result.next()) {
					int productId = result.getInt(1);
					int userId = result.getInt(2);
					String name = result.getString(3);
					int quanity = result.getInt(4);
					String price = result.getString(5);
					String category = result.getString(6);
					String publicDate = result.getString(7);
					String expireDate = result.getString(8);
					
					Product product = new Product(productId, userId, name, quanity, price, category, publicDate, expireDate);
					productList.add(product);
	
					}
			} catch (SQLException e) {
				System.out.println("Connection failed!");
			} finally {
				try {
					if(connection!=null) {
						connection.close();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return productList;
	}
	
	public Product getProduct(int id) {
		return null;
	}
	public void addProduct(Product student) {
		
	}
    public void updateProduct(Product student) {
		
	}
    public void deleteProduct(int id) {
		
	}
    
}
