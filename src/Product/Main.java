package Product;

import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ProductManager productManager = new ProductManager();
		List<Product> productList = new ArrayList<Product>();
		productList = productManager.getAllProduct();
		for(Product product:productList) {
			System.out.println(product);
		}
	}
	
}
