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
	
// create product
//	public void addProduct() throws ClassNotFoundException, SQLException {
//		Scanner input = new Scanner(System.in);
//		try{
//			System.out.println("Enter product name:");
//			String name = input.next();
//			System.out.println("Enter product quantity:");
//			int quantity = input.nextInt();
//			System.out.println("Enter product price:");
//			String price = input.next();
//			System.out.println("Enter product category:");
//			String category = input.next();
//			System.out.println("Enter product public_date:");
//			String public_date = input.next();
//			System.out.println("Enter product expire_date:");
//			String expire_date = input.next();
//
//			connection = ConnectionUtil.getMyConnection();;
//			pstmst = connection.prepareStatement ("INSERT INTO tbl_products (name,quantity,price,category,public_date,expire_date) VALUES(?,?,?,?,?,?)");
//			pstmst.setString(1,name);
//			pstmst.setInt(2, quantity);
//			pstmst.setString(3, price);
//			pstmst.setString(4, category);
//			pstmst.setString(5, public_date);
//			pstmst.setString(6, expire_date);
//			 int i = pstmst.executeUpdate();
//		      if(i!=0){
//		        System.out.println("add product successfull"); 
//		      }
//		      else{
//		        System.out.println("failed to add");
//		      }
//		}catch (Exception e){
//		     System.out.println(e);
//	    }
//
//	}
	
	// create product
	public void addProduct(String name_pro,int quantity_pro,String price_pro,String category_pro,String public_date_pro,String expire_date_pro) throws ClassNotFoundException { 

		try {
			connection = ConnectionUtil.getMyConnection();
		    String sql =  "INSERT INTO tbl_products (name,quantity,price,category,public_date,expire_date) VALUES('"+name_pro+"',"+quantity_pro+",'"+price_pro+"','"+category_pro+"','"+public_date_pro+"','"+expire_date_pro+"')";
		    pstmst = connection.prepareStatement(sql);
			 int data = pstmst.executeUpdate();
		      if(data!=0){
		        System.out.println("add product successfull"); 
		      }
		      else{
		        System.out.println("failed to add");
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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

}
