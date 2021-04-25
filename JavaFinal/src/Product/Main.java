package Product;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner userInput = new Scanner(System.in);
		int option;
		char userPress;
		showMeun();
		ProductManager productManager = new ProductManager();
		do {
			
			option = userInput.nextInt();
			
			switch(option) {
				case 1: 
					System.out.println("");
					System.out.println(" == LIST OF ALL PRODUCT RECORD == ");
					
						List<Product> productList = new ArrayList<Product>();
						productList = productManager.getAllProduct();
						for(Product product:productList) {
							System.out.println(product);
						}
					break;
				case 2: 
					System.out.println("");
					System.out.println(" == ADD NEW PRODUCT RECORD == ");
					
					break;
				case 3: 
					System.out.println("");
					System.out.println(" == UPDATE PRODUCT RECORD == ");
					
					
					break;
				case 4: 
					System.out.println("");
					System.out.println(" == DELETE PRODUCT RECORD == ");
					
					
					break;
				case 5: 
					System.out.println("");
					System.out.println(" == FIND PRODUCT RECORD == ");
					Scanner input = new Scanner(System.in);
					System.out.println("");
				    System.out.print("Input customer ID: ");
				    int id = input.nextInt();
					if(productManager.findProduct(id) != null) {
						System.out.println(productManager.findProduct(id));
					} else {
						System.out.println("Product record not found!");
					}
					
					break;
				case 6: 
					System.out.println("");
					System.out.println(" ==  SEARCH PRODUCT RECORD == ");
					
					
					break;
				default: 
					System.out.println("");
					System.out.println("Invalid input!");
					break;
			}
			System.out.println("");
			System.out.print("Press anykey to continue<Y/y>...");
			userPress = userInput.next().charAt(0); 
		    if (userPress == 'Y' || userPress == 'y') {
		    	showMeun();
		    } 
		    	
			
		} while(option != 0);
	}
	
	public static void showMeun() {
		System.out.println("=============");
		System.out.println("  Main Menu  ");
		System.out.println("=============");
		System.out.println("1. List all product record");
		System.out.println("2. Create a new product record");
		System.out.println("3. Update the product record");
		System.out.println("4. Delete the product record");
		System.out.println("5. Find the product record");
		System.out.println("6. Search the product record");
		System.out.println("0. Exit the system...");
		System.out.print("\nEnter Option (0-6): ");
	}
	
}
