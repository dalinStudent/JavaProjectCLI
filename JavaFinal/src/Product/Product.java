package Product;

public class Product {
	
	private int productId;
	private int userId;
	private String name;
	private int quantity;
	private String price;
	private String category;
	
	public Product() {
		
	}
	public Product(int userId, String name, int quantity, String price, String category) {
		super();
		this.userId = userId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	public Product(int productId, int userId, String name, int quantity, String price, String category) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	@Override
	public String toString() {
		return "\n ----------------------------------------------------------------------------------------|"+
			      "\n ProductId  UserId   Product Name    Quantity  Price   Category   |"+
			      "\n ----------------------------------------------------------------------------------------| "+
			      "\n|"+productId+ "          " +userId+"         " +name+"         "+quantity+"       "+price+"      "+category+
			       "\n ----------------------------------------------------------------------------------------|";
			     
	}
	
}
