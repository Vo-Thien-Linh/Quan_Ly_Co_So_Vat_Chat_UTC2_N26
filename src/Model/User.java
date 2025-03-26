package Model;

public class User {
	private String username;
	private int yearold;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;

    public User(String username, int yearold, String email, String phoneNumber, String password, Role role) {
        this.username = username;
        this.yearold = yearold;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

	public String getUsername() {
        return username;
    }
	
	public int getYearold() {
		return yearold;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

    public String getPassword() {
        return password;
    }
    
    public Role getRole() {
    	return role;
    }
}
