package Product;

import java.sql.*;
import java.util.*;

public class Login {
	static Connection connection = null;
	static ResultSet result;
	static PreparedStatement pstmst;
	
	static ProductManager productManager = new ProductManager();	
	static UserManager userManager = new UserManager();
	static Product product = new Product();
	static User user = new User();
	static Scanner userInput = new Scanner(System.in);
	static char userPress;
	
	public static void login() throws ClassNotFoundException {
		try {
			connection = ConnectionUtil.getMyConnection();
            System.out.println("==================================");
            System.out.println("WELCOME TO STOCK MANAGEMENT SYSTEM");
            System.out.println("==================================");
            	System.out.print("\nEnter your Email : ");
            String email = userInput.next();
            	System.out.print("\nEnter your Password : ");
            String password = userInput.next();
            System.out.println("\n==================================");
			String sql =  "SELECT * FROM tbl_users WHERE email='" + email + "'" + " AND password = '" + password + "'";
			pstmst = connection.prepareStatement(sql);
			result = pstmst.executeQuery();
		
            if (result.next()) {
            	 System.out.println("\n>> Logged in successfully! << ");
            	 systemInfo();
            } else {
                System.out.println(">> Incorrect username or password <<");
                userInfo();
            }

            result.close();
            connection.close();

        } catch (SQLException e) {
            //error handling & print error message
            System.out.println("Error : " + e.getMessage());
        }
	}
	
	public static void systemInfo() throws ClassNotFoundException, SQLException {
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
					System.out.print("\nInput user id: ");
					int userId = userInput.nextInt();
					System.out.print("Input product name: ");
					String name = userInput.next();
					System.out.print("Input product quantity: ");
					int quantity = userInput.nextInt();
					System.out.print("Input product price: ");
					String price = userInput.next();
					System.out.print("Input product category: ");
					String category = userInput.next();
						product.setUserId(userId);
						product.setName(name);
						product.setQuantity(quantity);
						product.setPrice(price);
						product.setCategory(category);
					productManager.addProduct(product);
					break;
				case 3: 
					System.out.println("\n == UPDATE PRODUCT RECORD == ");
						System.out.print("\nEnter your product id to update: ");
				    int idProduct = userInput.nextInt();
						System.out.print("Enter your new product name: ");
					String nameProduct = userInput.next();
						System.out.print("Enter your new product quantity: ");
					int quantityProduct = userInput.nextInt();
						System.out.print("Enter your new product price: ");
					String priceProduct = userInput.next();
						System.out.print("Enter your new product category: ");
					String categoryProduct = userInput.next();
						product.setProductId(idProduct);
						product.setName(nameProduct);
						product.setQuantity(quantityProduct);
						product.setPrice(priceProduct);
						product.setCategory(categoryProduct);
					productManager.updateProduct(product);
					
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
					System.out.print("\nEnter Your Product Name: ");
					String nameSearch = userInput.next();
					if(productManager.searchProduct(nameSearch) != null) {
						System.out.println("\n>> Product found! <<");
						System.out.println(productManager.searchProduct(nameSearch));
					} else {
						System.out.println("\nProduct record not found!");
					}
					break;
				default: 
					System.out.println("\nInvalid input!");
					break;
			}
			System.out.print("\nPress anykey to continue<Y/y>...");
			userPress = userInput.next().charAt(0); 
		    if (userPress == 'Y' || userPress == 'y') {
		    	showMeun();
		    } 
		    	
			
		} while(option != 0);
	}
	
	public static void userInfo() throws ClassNotFoundException, SQLException {
		System.out.println("1. Create an new account?");
		System.out.println("2. View user detail");
		System.out.println("3. Update user detail");
		System.out.println("4. Delete user");
		System.out.println("5. Back to login");
		System.out.print("\nEnter your choice: ");
		int choice = userInput.nextInt();
		do {
				switch(choice) {
					case 1 : 
						System.out.println("\n == CREATE AN NEW ACCOUNT ==");
							System.out.print("\nInput the first name: ");
						String firstName = userInput.next();
							System.out.print("Input the last name: ");
						String lastName = userInput.next();
							System.out.print("Input the email: ");
						String email = userInput.next();
							System.out.print("Input the password: ");
						String password = userInput.next();
							System.out.print("Input the province: ");
						String province = userInput.next();
							System.out.print("Input the phone number: ");
						String phone = userInput.next();
							
							user.setFirstName(firstName);
							user.setLastName(lastName);
							user.setEmail(email);
							user.setPassword(password);
							user.setProvince(province);
							user.setPhone(phone);
						userManager.addUser(user);
						break;
					case 2 : 
						System.out.println("\n == USER DETAIL INFORMATION == ");
						System.out.print("\nInput user ID: ");
					    int id = userInput.nextInt();
					    
							if(userManager.findUser(id) != null) {
								System.out.println("\n>> User found! <<");
								System.out.println(userManager.findUser(id));
								login();
							} else {
								System.out.println("\nUser not found!");
							}
						break;
					case 3 : 
						System.out.println("\n == UPDATE USER DETAIL INFORMATION == ");
						System.out.print("\nEnter your user id to update: ");
					    int idUser = userInput.nextInt();
							System.out.print("Enter your new first name: ");
						String newFirstName = userInput.next();
							System.out.print("Enter your new last name: ");
						String newLastName = userInput.next();
							System.out.print("Enter your new email address: ");
						String newEmail = userInput.next();
							System.out.print("Enter your new password: ");
						String newPassword = userInput.next();
							System.out.print("Enter your new phone number: ");
						String newPhone = userInput.next();
							System.out.print("Enter your new province: ");
						String newProvince = userInput.next();
							user.setId(idUser);
							user.setFirstName(newFirstName);
							user.setLastName(newLastName);
							user.setEmail(newEmail);
							user.setPassword(newPassword);
							user.setPhone(newPhone);
							user.setProvince(newProvince);
						userManager.updateUser(user);
						break;
					case 4 : 
						System.out.println("\n == DELETE USER INFORMATION == ");
						System.out.print("\nInput product ID: ");
						int userId = userInput.nextInt();
						
						userManager.deleteUser(userId);
						break;
					case 5 : 
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
