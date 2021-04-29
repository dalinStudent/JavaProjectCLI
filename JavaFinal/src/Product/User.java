package Product;

public class User {
	
	private int id;
    private String firstName;
	private String lastName;
    private String province;
    private String email;
    private String password;
    private String phone;
    public User() {
    	
    }
    public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
    public User(int id, String firstName, String lastName, String email, String phone, String province) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.province = province;
		this.email = email;
		this.phone = phone;
	}
    
	public User(String firstName, String lastName, String email, String password, String phone, String province) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.province = province;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
        return password;
    }

    
	public void setPassword(String pass) {
		this.password = pass;
		
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "\n -------------------------------------------------------------------------|"+
			      "\n First Name      Last Name       Email          Phone          Province   |"+
			      "\n -------------------------------------------------------------------------|"+
			      "\n| " +firstName+"          " +lastName+"          "+email+"   "+phone+"  "+province+
			       "\n -------------------------------------------------------------------------|";
	}
}
