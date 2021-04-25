package Product;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		ProductManager productManager = new ProductManager();
//		List<Product> productList = new ArrayList<Product>();
//		productList = productManager.getAllProduct();
		
		
//		productManager.addProduct();
		
//		System.out.println("Enter product name:");
//		String name = input.next();
//		System.out.println("Enter product quantity:");
//		int quantity = input.nextInt();
//		System.out.println("Enter product price:");
//		String price = input.next();
//		System.out.println("Enter product category:");
//		String category = input.next();
//		System.out.println("Enter product public_date:");
//		String public_date = input.next();
//		System.out.println("Enter product expire_date:");
//		String expire_date = input.next();
//		productManager.addProduct(name, quantity, price, category, public_date, expire_date);
		

	    System.out.print("Enter Your Product Name: ");
	    String name_pro = input.next();
		if(productManager.searchProduct(name_pro) != null) {
			List<Product> productSearch = new ArrayList<Product>();
			productSearch = productManager.searchProduct(name_pro);
			for(Product product:productSearch) {
				System.out.println(" Product ID = "+product.getName()+
									" Userr ID = "+product.getUserId()+
									" Product Name = "+product.getName()+
									" Product Quantity = "+product.getQuantity()+
									" Product Price = "+product.getPrice()+
									" Product Category = "+product.getCategory()+
									" Product Public Date = "+product.getPublicDate()+
									" Product Expire Date = "+product.getExpireDate()
				);
			}
		} else {
			System.out.println("Product record not found!");
		}
//		for(Product product:productList) {
//			System.out.println(product);
//		}
	}
	
}
