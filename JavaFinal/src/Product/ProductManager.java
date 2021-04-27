package Product;

import java.sql.*;
import java.util.*;


public class ProductManager {
	static Connection connection = null;
	static Statement insertStatement = null;
	static Statement selectStatement = null;
	static Statement updateStatement = null;
	static ResultSet result = null;
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
					
					Product product = new Product(productId, userId, name, quanity, price, category);
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
	
	public void printCustomer(ArrayList<Product> products) {
		for(Product product: products) {
			System.out.println(product);
		}
	} 
	
	public Product findProduct(int id) throws ClassNotFoundException { 
		Product product = null;
		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "SELECT * FROM tbl_products WHERE product_id =" + id;
			pstmst = connection.prepareStatement(sql);
			result = pstmst.executeQuery();
			
			while(result.next()) {
				int productId = result.getInt(1);
				int userId = result.getInt(2);
				String name = result.getString(3);
				int quanity = result.getInt(4);
				String price = result.getString(5);
				String category = result.getString(6);
				
				product = new Product(productId, userId, name, quanity, price, category);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}
	
	public void addProduct(Product product) throws ClassNotFoundException, SQLException {
		connection = ConnectionUtil.getMyConnection();
		String sql = "INSERT INTO tbl_products (user_id, name, quantity, price, category) VALUES(?,?,?,?,?)";
		pstmst = connection.prepareStatement(sql);
	    pstmst.setInt(1, product.getUserId());
	    pstmst.setString(2, product.getName());
	    pstmst.setInt(3, product.getQuantity());
	    pstmst.setString(4, product.getPrice());
	    pstmst.setString(5, product.getCategory());

		 int data = pstmst.executeUpdate();
	      if(data!=0){
	        System.out.println("\n>> Add product successfully <<"); 
	      }
	      else{
	        System.out.println("\\n>> Add product unsuccessfull <<");
	      }
	}
    public void updateProduct(Product product) {
		
	}
    public void deleteProduct(int id) throws ClassNotFoundException, SQLException {
    	connection = ConnectionUtil.getMyConnection();
    	String sql = "DELETE FROM tbl_products WHERE product_id=" + id;
    	pstmst = connection.prepareStatement(sql);
    	int rowEffect = pstmst.executeUpdate();
    	System.out.println(">>\n Delete product successfully <<");
	}
    
    public Product searchProduct(String namePro) throws ClassNotFoundException { 
		Product product = null;
		try {
			connection = ConnectionUtil.getMyConnection();
			String sql =  "SELECT * FROM tbl_products WHERE name = '" + namePro + "'";
			pstmst = connection.prepareStatement(sql);
			result = pstmst.executeQuery();

			while(result.next()) {
				int productId = result.getInt(1);
				int userId = result.getInt(2);
				String name = result.getString(3);
				int quanity = result.getInt(4);
				String price = result.getString(5);
				String category = result.getString(6);
				product = new Product(productId, userId, name, quanity, price, category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}
    
}
