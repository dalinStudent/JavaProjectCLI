package Product;

import java.sql.*;
import java.util.*;

public class Login {
	static Connection connection = null;
	static Statement selectStatement = null;
	static ResultSet result;
	static PreparedStatement pstmst;
	
	ProductManager productManager = new ProductManager();	
	
	public void login() throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();

            Scanner scan = new Scanner(System.in);
            System.out.println("==================================");
            System.out.println("WELCOME TO STOCK MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.print("\nEnter your Email : ");
            String email = scan.nextLine();

            System.out.print("\nEnter your Password : ");
            String password = scan.nextLine();
            System.out.println("\n================================");
            
			selectStatement = connection.createStatement();
			result = selectStatement.executeQuery("SELECT * FROM tbl_users WHERE email='" + email + "'" + " AND password = '" + password + "'");

            if (result.next()) {
            	 System.out.println("\n>> Logged in successfully! << ");
            	choidChoos();
            } else {
                System.out.println("Wrong username or password");
            }

            result.close();
            connection.close();

        } catch (SQLException e) {
            //error handling & print error message
            System.out.println("Error : " + e.getMessage());
        }
	}
	
	public void choidChoos() throws ClassNotFoundException {
		Scanner userInput = new Scanner(System.in);
		int option;
		char userPress;
		showMeun();
		do {
			
			option = userInput.nextInt();
			
			switch(option) {
				case 1: 
					
					System.out.println("\n == LIST OF ALL PRODUCT RECORD == ");
						List<Product> productList = new ArrayList<Product>();
						productList = productManager.getAllProduct();
						for(Product product:productList) {
							System.out.println(product);
						}
					break;
				case 2: 
					System.out.println("\n == ADD NEW PRODUCT RECORD == ");
					
					break;
				case 3: 
					System.out.println("\n == UPDATE PRODUCT RECORD == ");
					
					
					break;
				case 4: 
					System.out.println("\n == DELETE PRODUCT RECORD == ");
					
					
					break;
				case 5: 
					System.out.println("\n == FIND PRODUCT RECORD == ");
					Scanner input = new Scanner(System.in);
				    System.out.print("\nInput product ID: ");
				    int id = input.nextInt();
					if(productManager.findProduct(id) != null) {
						System.out.println(productManager.findProduct(id));
					} else {
						System.out.println("\nProduct record not found!");
					}
					
					break;
				case 6: 
					System.out.println("\n ==  SEARCH PRODUCT RECORD == ");
					
					
					break;
				default: 
					System.out.println("\nInvalid input!");
					break;
			}
			System.out.println("\nPress anykey to continue<Y/y>...");
			userPress = userInput.next().charAt(0); 
		    if (userPress == 'Y' || userPress == 'y') {
		    	showMeun();
		    } 
		    	
			
		} while(option != 0);
	}
	
	public static void showMeun() {
		System.out.println("\n=================================");
		System.out.println("      Main Menu 	");
		System.out.println("==================================");
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
