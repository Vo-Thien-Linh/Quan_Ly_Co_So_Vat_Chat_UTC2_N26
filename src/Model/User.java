package Model;

public abstract class User {
	private String user_id;
	private String fullname;
	private String username;
	private String yearold;
    private String email;
    private String phoneNumber;
    private String password;
    private Status status;
    private Role role;
    private boolean deleted = false;

    public User(String fullname, String username, String yearold, String email, String phoneNumber, String password, Status status, Role role) {
    	this.fullname = fullname;
        this.username = username;
        this.yearold = yearold;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.status = status;
        this.role = role;
    }
    
    public String getUserId() {
        return user_id;
    }
    	
    public String getFullname() {
        return fullname;
    }
    
	public String getUsername() {
        return username;
    }
	
	public String getYearold() {
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
    
    public Status getStatus() {
        return status;
    }
    
    
    public Role getRole() {
    	return role;
    }
    
    public Boolean deleted() {
    	return deleted;
    }
    
    public abstract void displayInformationUser();
}
