package Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	static Connection connection = null;
	static Statement selectStatement = null;
	static ResultSet result;
	static PreparedStatement pstmst;
	
	
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
	
	
	public void login() throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();

            Scanner scan = new Scanner(System.in);
            System.out.println("==================================");
            System.out.println("WELCOME TO STOCK MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.print("Email : ");
            String email = scan.nextLine();

            System.out.print("Password : ");
            String password = scan.nextLine();
            System.out.println("==================================");
            
			selectStatement = connection.createStatement();
			result = selectStatement.executeQuery("SELECT * FROM tbl_users WHERE email='" + email + "'" + " AND password = '" + password + "'");

            if (result.next()) {
//                System.out.println("Successfully login as " + result.getString("email"));
//                showMeun();
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
					System.out.println("");
					System.out.println(" == LIST OF ALL PRODUCT RECORD == ");
						ProductManager productManager = new ProductManager();
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
			System.out.println("Press anykey to continue<Y/y>...");
			userPress = userInput.next().charAt(0); 
		    if (userPress == 'Y' || userPress == 'y') {
		    	showMeun();
		    } 
		    	
			
		} while(option != 0);
	}
	

}
