package Product;

public class Product {
	
	private int productId;
	private int userId;
	private String name;
	private int quantity;
	private String price;
	private String category;
	private String publicDate;
	private String expireDate;
	
	public Product() {
		
	}
	public Product(int userId, String name, int quantity, String price, String category, String publicDate, String expireDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.publicDate = publicDate;
		this.expireDate = expireDate;
	}
	
	public Product(int productId, int userId, String name, int quantity, String price, String category, String publicDate, String expireDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.publicDate = publicDate;
		this.expireDate = expireDate;
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

	public String getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	@Override
	public String toString() {
		return "\n ----------------------------------------------------------------------------------------|"+
			      "\n|  ProductId  UserId   Quantity  Price   Category   Public Date   Expire Date|"+
			      "\n ----------------------------------------------------------------------------------------| \n|"  + 
			      "    "+productId+"          " +userId+"         "+quantity+"       "+price+"      "+category+"      "+publicDate+"      "+expireDate+
			      "\n ----------------------------------------------------------------------------------------|";
	}
	
	
}
