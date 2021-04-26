package Product;

import java.sql.*;
import java.util.*;

public class Login {
	static Connection connection = null;
	static Statement selectStatement = null;
	static ResultSet result;
	static PreparedStatement pstmst;
	
	static ProductManager productManager = new ProductManager();	
	static UserManager userManager = new UserManager();
	static Scanner userInput = new Scanner(System.in);
	static char userPress;
	
	public static void login() throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();
            System.out.println("==================================");
            System.out.println("WELCOME TO STOCK MANAGEMENT SYSTEM");
            System.out.println("==================================");
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter your Email : ");
            String email = scanner.nextLine();
            System.out.print("\nEnter your Password : ");
            String password = scanner.nextLine();
            System.out.println("\n==================================");
            
			selectStatement = connection.createStatement();
			result = selectStatement.executeQuery("SELECT * FROM tbl_users WHERE email='" + email + "'" + " AND password = '" + password + "'");

            if (result.next()) {
            	 System.out.println("\n>> Logged in successfully! << ");
            	choidChoos();
            } else {
                System.out.println(">> Incorrect username or password <<");
                registerUser();
            }

            result.close();
            connection.close();

        } catch (SQLException e) {
            //error handling & print error message
            System.out.println("Error : " + e.getMessage());
        }
	}
	
	public static void choidChoos() throws ClassNotFoundException, SQLException {
		showMeun();
		int option;
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
					Scanner userCreate = new Scanner(System.in);
				    
					System.out.print("Input product name: ");
					String name = userCreate.nextLine();
					System.out.print("Input product price: ");
					String price = userCreate.nextLine();
					System.out.print("Input product category: ");
					String category = userCreate.nextLine();
					System.out.print("Input product quantity: ");
					int quantity = userCreate.nextInt();
					System.out.print("Input user id: ");
					int userId = userCreate.nextInt();
					productManager.addProduct(userId, name, quantity, price, category);
					break;
				case 3: 
					System.out.println("\n == UPDATE PRODUCT RECORD == ");
					
					
					break;
				case 4: 
					System.out.println("\n == DELETE PRODUCT RECORD == ");
					System.out.print("\nInput product ID: ");
					int delete = userInput.nextInt();
					productManager.deleteProduct(delete);
					break;
				case 5: 
					System.out.println("\n == FIND PRODUCT RECORD == ");
				    System.out.print("\nInput product ID: ");
				    int id = userInput.nextInt();
					if(productManager.findProduct(id) != null) {
						System.out.println("\n>> Product found! <<");
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
	
	public static void registerUser() throws ClassNotFoundException {
		System.out.println("1. Create an new account?");
		System.out.println("2. Back to login");
		System.out.print("\nEnter your choice: ");
		int choice = userInput.nextInt();
		do {
				switch(choice) {
					case 1 : 
						System.out.println("\n == REGISTER A NEW ACCOUNT==");
						Scanner user = new Scanner(System.in);
						System.out.print("Input the first name: ");
						String firstName = user.nextLine();
						System.out.print("Input the last name: ");
						String lastName = user.nextLine();
						System.out.print("Input the province: ");
						String province = user.nextLine();
						System.out.print("Input the phone number: ");
						String phone = user.nextLine();
						System.out.print("Input the email: ");
						String email = user.nextLine();
						System.out.print("Input the password: ");
						String password = user.nextLine();
						userManager.addUser(firstName,lastName,province,phone,email,password);
						break;
					case 2 : 
						login();
						break;
				}
		} while(choice!=0);
	}
	
	public static void showMeun() {
		System.out.println("\n==================================");
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
