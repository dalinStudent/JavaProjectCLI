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
	

	
	// create product
	public void addProduct(Product product) throws ClassNotFoundException, SQLException {
		try{
			connection = ConnectionUtil.getMyConnection();
			String sql = "INSERT INTO tbl_products (user_id,name,quantity,price,category,public_date,expire_date) VALUES(?,?,?,?,?,?,?)";
			pstmst = connection.prepareStatement (sql);
		    pstmst.setInt(1, product.getUserId());
		    pstmst.setString(2, product.getName());
		    pstmst.setInt(3, product.getQuantity());
		    pstmst.setString(4, product.getPrice());
		    pstmst.setString(5, product.getCategory());
		    pstmst.setString(6, product.getPublicDate());
		    pstmst.setString(7, product.getExpireDate());
		    int data = pstmst.executeUpdate();
		    if(data!=0){
		    	System.out.println("\n>> created product successfully <<"); 
		    }
		    else{
		    	System.out.println("\\n>> create product unsuccessfull <<");
		    }
		}catch (Exception e){
		     System.out.println(e);
	    }

	}
	
	
	
	// search product by name
	public List<Product> searchProduct(String name_pro) throws ClassNotFoundException { 
		List<Product> productSearch = new ArrayList<Product>();
		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "SELECT * FROM tbl_products WHERE name = '"+name_pro+"'";
			pstmst = connection.prepareStatement(sql);
			result = pstmst.executeQuery();

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
				productSearch.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productSearch;
	}
	

	
	// update product
	public void updateProduct(Product product) throws ClassNotFoundException { 

		try {
				connection = ConnectionUtil.getMyConnection();
				String sql = "UPDATE tbl_products SET user_id=?, name=?, quantity=?, price=?, category=?, public_date=?, expire_date=?  WHERE product_id=?";
				pstmst = connection.prepareStatement(sql);
			    pstmst.setInt(1, product.getUserId());
			    pstmst.setString(2, product.getName());
			    pstmst.setInt(3, product.getQuantity());
			    pstmst.setString(4, product.getPrice());
			    pstmst.setString(5, product.getCategory());
			    pstmst.setString(6, product.getPublicDate());
			    pstmst.setString(7, product.getExpireDate());
				pstmst.setInt(8, product.getProductId());
			    int data = pstmst.executeUpdate();
			    if(data!=0){
			    	System.out.println("\n>> update product successfully <<"); 
			    }
			    else{
			    	System.out.println("\\n>> update product unsuccessfull <<");
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
































