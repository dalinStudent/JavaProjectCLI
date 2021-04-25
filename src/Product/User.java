package Product;

public class User {
	private int id;
    private String fullname;
    private String email;
    private String password;
    
    
    public String getMail() {
        return email;
    }
    
    public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	
}
